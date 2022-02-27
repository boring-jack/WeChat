package com.jack.weChatSecurity.core;

import com.jack.weChatSecurity.config.JsonConfig;
import com.jack.weChatSecurity.config.SecurityConfig;
import com.jack.weChatSecurity.config.exception.NoDatasourceConfigException;
import com.jack.weChatSecurity.datasource.Datasource;
import com.jack.weChatSecurity.datasource.DatasourceFactory;
import com.jack.weChatSecurity.datasource.exception.NotFindDatasourceException;
import com.jack.weChatSecurity.wechat.WeChat;
import com.jack.weChatSecurity.wechat.WeChatConfig;
import com.jack.weChatSecurity.wechat.WeChatImpl;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class SecurityBase implements Security,SecurityContext, Serializable {
    private static final long serialVersionUID = 1L;
    private static int SESSION_DAY=15;
    private static int KEEP_DAY=0;
    private static WeChatConfig weChat=new WeChatImpl();

    private Map<String, CurrentUser> SESSION_MAP =new ConcurrentHashMap<>();
    transient private Datasource DATASOURCE;


    @Override
    public void init(JsonConfig jsonConfig) throws NoDatasourceConfigException, NotFindDatasourceException ,IOException ,ClassNotFoundException{
        SecurityConfig securityConfig=jsonConfig.getSecurityConfig();
        DATASOURCE=DatasourceFactory.createDatasource(securityConfig.getDataSourceConfig());
        SESSION_DAY=securityConfig.getSessionDay();
        KEEP_DAY=securityConfig.getKeepDay();
        weChat.setAppID(jsonConfig.getAPP_ID());
        weChat.setSecret(jsonConfig.getSECRET());
    }

    public WeChat getWeChat(){return (WeChat) weChat;}

    public CurrentUser get(String token){
        return SESSION_MAP.get(token);
    }

    public boolean contain(String token){
        return SESSION_MAP.containsKey(token);
    }

    public void put(String token,CurrentUser currentUser){
        SESSION_MAP.put(token, currentUser);
    }

    public void remove(String token){
        SESSION_MAP.remove(token);
    }

    @Override
    public int getSessionDay() {
        return SESSION_DAY;
    }

    @Override
    public int getKeepDay() {
        return KEEP_DAY;
    }

    @Override
    public Map<String, CurrentUser> getSessionMap() {
        return SESSION_MAP;
    }

    @Override
    public Datasource getDataSource() {
        return this.DATASOURCE;
    }

    public class DefaultCurrentUser implements CurrentUser,Serializable{

        private String token;
        private String id;
        private Timestamp registerTime;
        private Map<String,Object> data;
        private List<String> roles;

        public DefaultCurrentUser(){
            this.registerTime=new Timestamp(System.currentTimeMillis());
            this.data=new HashMap<>();
            this.roles=new ArrayList<>();
        }

        protected void setToken(String token) {
            this.token=token;
        }

        protected void setId(String id) {
            this.id = id;
        }

        protected void setRoles(List<String> roles){this.roles=roles;}

        @Override
        public String getToken() {
            return token;
        }

        @Override
        public long getLastTime() {
            return registerTime.getTime();
        }

        @Override
        public String getId() {
            return id;
        }

        protected boolean checkTokenExpire(){
            Timestamp now=new Timestamp(System.currentTimeMillis());
            Timestamp expect=new Timestamp(this.registerTime.getTime()+ (SESSION_DAY*24*60*60*1000l));
            return now.after(expect);
        }

        @Override
        public <T> void setAttribute(String name, T value) {
            data.put(name,value);
        }

        @Override
        public <T> T getAttribute(String name) {
            return (T)data.get(name);
        }

        @Override
        public boolean hasRole(String role) {
            return this.roles.contains(role);
        }
    }
}
