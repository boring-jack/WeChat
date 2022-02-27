package com.jack.weChatSecurity.datasource.jdbc;

import com.jack.weChatSecurity.config.datasourceConfig.JdbcDataSourceConfig;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class JdbcDatasourceBase implements JdbcDatasource {

    private DataSource DATASOURCE;

    @Override
    public void init(JdbcDataSourceConfig config) {
        BasicDataSource dataSource=new BasicDataSource();
        dataSource.setUrl(config.getUrl());
        dataSource.setDriverClassName(config.getDriver());
        dataSource.setUsername(config.getUsername());
        dataSource.setPassword(config.getPassword());

        DATASOURCE=dataSource;
    }

    @Override
    public List<String> getRoles() {
        try {
            return doGetRoles(DATASOURCE.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public abstract List<String> doGetRoles(Connection connection);
}
