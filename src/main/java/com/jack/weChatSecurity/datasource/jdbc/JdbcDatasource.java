package com.jack.weChatSecurity.datasource.jdbc;

import com.jack.weChatSecurity.config.datasourceConfig.JdbcDataSourceConfig;
import com.jack.weChatSecurity.datasource.Datasource;

public interface JdbcDatasource extends Datasource {

    void init(JdbcDataSourceConfig config);

}
