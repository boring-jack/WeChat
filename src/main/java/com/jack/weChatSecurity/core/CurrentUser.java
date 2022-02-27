package com.jack.weChatSecurity.core;

import java.util.List;

public interface CurrentUser {

    String getToken();

    String getId();

    long getLastTime();

    <T> void setAttribute(String name,T value);

    <T> T getAttribute(String name);

    boolean hasRole(String role);

}
