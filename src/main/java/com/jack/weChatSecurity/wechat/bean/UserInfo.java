package com.jack.weChatSecurity.wechat.bean;

public class UserInfo {
    private String avatarUrl;
    private String city;
    private String country;
    private int gender;
    private String language;
    private String nickName;
    private String province;

    public UserInfo(){}

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "avatarUrl='" + avatarUrl + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", gender='" + gender + '\'' +
                ", language='" + language + '\'' +
                ", nickName='" + nickName + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
