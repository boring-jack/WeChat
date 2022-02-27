package com.jack.weChatSecurity.core;

import com.jack.weChatSecurity.config.JsonConfig;
import com.jack.weChatSecurity.config.exception.NoDatasourceConfigException;
import com.jack.weChatSecurity.core.exception.TokenExpireException;
import com.jack.weChatSecurity.core.exception.UnknownTokenException;
import com.jack.weChatSecurity.datasource.exception.NotFindDatasourceException;
import com.jack.weChatSecurity.monitor.Monitor;
import com.jack.weChatSecurity.monitor.DefaultMonitor;

import java.io.*;
import java.net.URL;

public final class SecurityHelper {
    private static String SESSION_LOCATION= "D:\\session.txt";
    private static Security security;
    private static ThreadLocal<CurrentUser> currentUser;
    private static Monitor monitor;

    static {
        currentUser=ThreadLocal.withInitial(()->{return null;});
        monitor=new DefaultMonitor();
    }

    protected static void init(JsonConfig jsonConfig)throws NoDatasourceConfigException, NotFindDatasourceException ,IOException,ClassNotFoundException{
        SESSION_LOCATION=jsonConfig.getSecurityConfig().getSessionLocation();
        File file=new File(SESSION_LOCATION);
        if(!file.exists()){
            file.createNewFile();
            security=new DefaultSecurity();
        }else{
            ObjectInputStream in=new ObjectInputStream(new FileInputStream(SESSION_LOCATION));
            security=(Security) in.readObject();
            in.close();
        }
        ((SecurityContext)security).init(jsonConfig);
        monitor.registerSecurityContext((SecurityContext) security);
        new Thread(monitor,"SecurityMonitor").start();
    }

    protected static void destroy()throws IOException{
        if(SESSION_LOCATION!=null) {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SESSION_LOCATION));
            out.writeObject(security);
            out.close();
        }
    }

    public static CurrentUser getCurrentUser(){
        return currentUser.get();
    }

    public static String register(String code){
        return security.register(code);
    }

    public static void logout(){
        security.logout(currentUser.get().getToken());
        currentUser.remove();
    }

    protected static void setCurrentUser(CurrentUser user){
        currentUser.set(user);
    }

    protected static void login(String token)throws UnknownTokenException, TokenExpireException {
        security.login(token);
    }
}
