package com.jack.weChatSecurity.wechat;

import com.jack.weChatSecurity.wechat.bean.SessionKey$OpenId;

public abstract class WeChatBase implements WeChat,WeChatConfig{
    String WECHAT="https://api.weixin.qq.com/sns/jscode2session";
    String GRANT_TYPE="authorization_code";
    String APP_ID="wxc51856e094e99c5d";
    String SECRET="0a80f304a97eb22549e472032e67ebf6";

    @Override
    public void setAppID(String appID) {
        APP_ID=appID;
    }

    @Override
    public void setSecret(String secret) {
        SECRET=secret;
    }
}
