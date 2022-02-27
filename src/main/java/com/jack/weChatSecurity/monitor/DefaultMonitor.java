package com.jack.weChatSecurity.monitor;

import com.jack.weChatSecurity.core.SecurityContext;
import com.jack.weChatSecurity.core.CurrentUser;
import com.jack.weChatSecurity.datasource.Datasource;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Map;

public class DefaultMonitor implements Monitor{
    private SecurityContext security;

    @Override
    public void registerSecurityContext(SecurityContext securityContext) {
        security=securityContext;
    }

    @Override
    public void run() {
        Map<String, CurrentUser> sessionMap= security.getSessionMap();
        while(true){
            for(Map.Entry<String,CurrentUser> entry:sessionMap.entrySet()){
                String token= entry.getKey();
                CurrentUser currentUser= entry.getValue();
                int day=security.getSessionDay()+security.getKeepDay();
                Timestamp expect=new Timestamp(currentUser.getLastTime()+(day*24*60*60*1000l));
                Timestamp now=new Timestamp(System.currentTimeMillis());
                if(now.after(expect)){
                    sessionMap.remove(token);
                    System.out.println("remove!!");
                }
            }
        }
    }


}
