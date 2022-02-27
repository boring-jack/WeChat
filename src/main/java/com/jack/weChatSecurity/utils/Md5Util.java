package com.jack.weChatSecurity.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public final class Md5Util {
    private static MessageDigest messageDigest;

    static {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * MD5加密
     * @return
     */
    public static String encode(String source,String salt){
        String encode=null;
        try {
            messageDigest.update(source.getBytes("UTF-8"));
            byte[] digest=messageDigest.digest(salt.getBytes());
            encode= Base64.getEncoder().encodeToString(digest);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encode;
    }

}
