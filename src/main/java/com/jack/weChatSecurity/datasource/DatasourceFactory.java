package com.jack.weChatSecurity.datasource;

import com.jack.weChatSecurity.config.datasourceConfig.DatasourceConfig;
import com.jack.weChatSecurity.config.datasourceConfig.JdbcDataSourceConfig;
import com.jack.weChatSecurity.datasource.diy.DiyDatasource;
import com.jack.weChatSecurity.datasource.exception.NotFindDatasourceException;
import com.jack.weChatSecurity.datasource.jdbc.JdbcDatasource;

public final class DatasourceFactory {

    public static Datasource createDatasource(DatasourceConfig datasourceConfig)throws NotFindDatasourceException {
        try {
            Class cls=Class.forName(datasourceConfig.getPath());
            if(JdbcDatasource.class.isAssignableFrom(cls)){
                JdbcDataSourceConfig jdbcDataSourceConfig=(JdbcDataSourceConfig)datasourceConfig;
                JdbcDatasource jdbcDatasource=(JdbcDatasource) cls.newInstance();
                jdbcDatasource.init(jdbcDataSourceConfig);
                return jdbcDatasource;
            }
            if(DiyDatasource.class.isAssignableFrom(cls)){
                DiyDatasource diyDatasource=(DiyDatasource) cls.newInstance();
                return diyDatasource;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new NotFindDatasourceException("没有匹配到数据源");
    }
}
