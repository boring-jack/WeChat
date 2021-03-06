package com.jack.weChatSecurity.wechat.bean;

public class WeChatUserProfile {

    private String cloudID;
    private String encryptedData;
    private String errMsg;
    private String iv;
    private String rawData;
    private String signature;
    private UserInfo userInfo;

    public WeChatUserProfile(){}

    public String getCloudID() {
        return cloudID;
    }

    public void setCloudID(String cloudID) {
        this.cloudID = cloudID;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "WeChatUserProfile{" +
                "cloudID='" + cloudID + '\'' +
                ", encryptedData='" + encryptedData + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", iv='" + iv + '\'' +
                ", rawData='" + rawData + '\'' +
                ", signature='" + signature + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
