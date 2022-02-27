package com.jack.weChatSecurity.config;

public class JsonConfig {

    private String APP_ID;
    private String SECRET;
    private SecurityConfig securityConfig;

    public String getAPP_ID() {
        return APP_ID;
    }

    public void setAPP_ID(String APP_ID) {
        this.APP_ID = APP_ID;
    }

    public String getSECRET() {
        return SECRET;
    }

    public void setSECRET(String SECRET) {
        this.SECRET = SECRET;
    }

    public SecurityConfig getSecurityConfig() {
        return securityConfig;
    }

    public void setSecurityConfig(SecurityConfig securityConfig) {
        this.securityConfig = securityConfig;
    }

    @Override
    public String toString() {
        return "JsonConfig{" +
                "APP_ID='" + APP_ID + '\'' +
                ", SECRET='" + SECRET + '\'' +
                ", securityConfig=" + securityConfig +
                '}';
    }
}
