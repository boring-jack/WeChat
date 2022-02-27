package com.jack.weChatSecurity.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class JsonUtil {
    private static ObjectMapper mapper=new ObjectMapper();

    public static String getStringByJsonFile(InputStream in){
        StringBuilder builder=new StringBuilder();
        try{
            BufferedReader reader=new BufferedReader(new InputStreamReader(in,"UTF-8"));
            while(reader.ready()){
                builder.append(reader.readLine());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static <T> T getObjectByJson(String json,Class<T> cls)throws Exception{
        return mapper.readValue(json,cls);
    }

    public static String getJsonByObject(Object obj)throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }
}
