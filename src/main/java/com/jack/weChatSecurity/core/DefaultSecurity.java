package com.jack.weChatSecurity.core;

import com.jack.weChatSecurity.config.JsonConfig;
import com.jack.weChatSecurity.config.SecurityConfig;
import com.jack.weChatSecurity.config.exception.NoDatasourceConfigException;
import com.jack.weChatSecurity.core.exception.TokenExpireException;
import com.jack.weChatSecurity.core.exception.UnknownTokenException;
import com.jack.weChatSecurity.datasource.DatasourceFactory;
import com.jack.weChatSecurity.datasource.exception.NotFindDatasourceException;
import com.jack.weChatSecurity.core.token.DefaultTokenGenerator;
import com.jack.weChatSecurity.core.token.TokenGenerator;
import com.jack.weChatSecurity.wechat.bean.SessionKey$OpenId;

public class DefaultSecurity extends SecurityBase{

    private static TokenGenerator tokenGenerator=new DefaultTokenGenerator();

    @Override
    public void login(String token) throws TokenExpireException, UnknownTokenException {
        if(this.contain(token)){
            DefaultCurrentUser currentUser =(DefaultCurrentUser) this.get(token);
            if(!currentUser.checkTokenExpire()){
                currentUser.setRoles(this.getDataSource().getRoles());
                SecurityHelper.setCurrentUser(currentUser);
            }else throw new TokenExpireException("令牌过期");
        }else throw new UnknownTokenException("非法令牌");
    }

    @Override
    public String register(String code) {
        SessionKey$OpenId sessionKey$OpenId=getWeChat().getSessionKey$OpenId(code);
        DefaultCurrentUser currentUser=new DefaultCurrentUser();
        String newToken=tokenGenerator.createToken(currentUser);
        currentUser.setToken(newToken);
        currentUser.setId(sessionKey$OpenId.getOpenId());
        currentUser.setRoles(this.getDataSource().getRoles());
        this.put(newToken,currentUser);
        SecurityHelper.setCurrentUser(currentUser);
        return newToken;
    }

    @Override
    public void logout(String token) {
        this.remove(token);
        SecurityHelper.setCurrentUser(null);
    }

}
