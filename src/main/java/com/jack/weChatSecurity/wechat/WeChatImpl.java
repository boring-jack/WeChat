package com.jack.weChatSecurity.wechat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jack.weChatSecurity.utils.StreamUtil;
import com.jack.weChatSecurity.wechat.bean.SessionKey$OpenId;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeChatImpl extends WeChatBase {

    @Override
    public SessionKey$OpenId getSessionKey$OpenId(String code) {
        HttpURLConnection connection;
        ObjectMapper mapper=new ObjectMapper();
        SessionKey$OpenId sessionKey$OpenId=null;
        try {
            String url= WECHAT+"?appid="+ APP_ID+"&secret="+ SECRET+"&js_code="+code+"&grant_type="+ GRANT_TYPE;
            connection=(HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            connection.connect();
            String json= StreamUtil.getStringFromStream(connection.getInputStream());
            sessionKey$OpenId= mapper.readValue(json, SessionKey$OpenId.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            return sessionKey$OpenId;
        }
    }
}
