package com.lena.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


/**
 * @ClassName Druidconfig
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/10/11 14:32
 * @Version 1.0
 */
@Configuration
public class Druidconfig {


    @Bean(destroyMethod = "close",initMethod = "init")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDataSourceOne(){
        return new DruidDataSource();
    }
}
