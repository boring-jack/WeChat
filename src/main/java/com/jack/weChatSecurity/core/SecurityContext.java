package com.jack.weChatSecurity.core;

import com.jack.weChatSecurity.config.JsonConfig;
import com.jack.weChatSecurity.config.exception.NoDatasourceConfigException;
import com.jack.weChatSecurity.datasource.Datasource;
import com.jack.weChatSecurity.datasource.exception.NotFindDatasourceException;

import java.io.IOException;
import java.util.Map;

public interface SecurityContext {

    void init(JsonConfig jsonConfig)throws NoDatasourceConfigException, NotFindDatasourceException,IOException,ClassNotFoundException;

    Map<String, CurrentUser> getSessionMap();

    int getSessionDay();

    int getKeepDay();

    Datasource getDataSource();
}
