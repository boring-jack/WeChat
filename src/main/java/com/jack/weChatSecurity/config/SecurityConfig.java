package com.jack.weChatSecurity.config;

import com.jack.weChatSecurity.config.datasourceConfig.DatasourceConfig;
import com.jack.weChatSecurity.config.datasourceConfig.DiyDataSourceConfig;
import com.jack.weChatSecurity.config.datasourceConfig.JdbcDataSourceConfig;
import com.jack.weChatSecurity.config.exception.NoDatasourceConfigException;

import java.util.List;

public class SecurityConfig {

    private String sessionLocation;
    private int sessionDay;
    private int keepDay;
    private List<String> inUrl;
    private List<String> exUrl;
    private DiyDataSourceConfig diyDataSourceConfig;
    private JdbcDataSourceConfig jdbcDataSourceConfig;

    public String getSessionLocation() {
        return sessionLocation;
    }

    public DatasourceConfig getDataSourceConfig()throws NoDatasourceConfigException {
        DatasourceConfig datasourceConfig;
        if(diyDataSourceConfig!=null){
            datasourceConfig=diyDataSourceConfig;
        }
        else if(jdbcDataSourceConfig!=null){
            datasourceConfig=jdbcDataSourceConfig;
        }else{
            throw new NoDatasourceConfigException("没有配置数据源");
        }
        return datasourceConfig;
    }

    public void setDataSourceConfig(DiyDataSourceConfig dataSourceConfig) {
        this.diyDataSourceConfig = dataSourceConfig;
    }

    public void setJdbcDataSourceConfig(JdbcDataSourceConfig jdbcDataSourceConfig) {
        this.jdbcDataSourceConfig = jdbcDataSourceConfig;
    }

    public int getSessionDay() {
        return sessionDay;
    }

    public void setSessionDay(int sessionDay) {
        this.sessionDay = sessionDay;
    }

    public int getKeepDay() {
        return keepDay;
    }

    public void setKeepDay(int keepDay) {
        this.keepDay = keepDay;
    }

    public List<String> getInUrl() {
        return inUrl;
    }

    public void setInUrl(List<String> inUrl) {
        this.inUrl = inUrl;
    }

    public List<String> getExUrl() {
        return exUrl;
    }

    public void setExUrl(List<String> exUrl) {
        this.exUrl = exUrl;
    }

    @Override
    public String toString() {
        return "SecurityConfig{" +
                "sessionDay=" + sessionDay +
                ", keepDay=" + keepDay +
                ", inUrl=" + inUrl +
                ", exUrl=" + exUrl +
                ", diyDataSourceConfig=" + diyDataSourceConfig +
                ", jdbcDataSourceConfig=" + jdbcDataSourceConfig +
                '}';
    }
}
