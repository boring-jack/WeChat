package com.jack.weChatSecurity.core;

import com.jack.weChatSecurity.core.exception.TokenExpireException;
import com.jack.weChatSecurity.core.exception.UnknownTokenException;

public interface Security{

    void login(String token)throws TokenExpireException, UnknownTokenException;

    /**
     * 注册进sessionMap<token,CurrentUser>
     * @param code
     * @return String 返回Token
     */
    String register(String code);

    void logout(String token);

}
