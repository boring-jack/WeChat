package com.jack.weChatSecurity.wechat.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SessionKey$OpenId {
    @JsonProperty("session_key")
    private String sessionKey;
    @JsonProperty("openid")
    private String openId;

    public SessionKey$OpenId(){}

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
