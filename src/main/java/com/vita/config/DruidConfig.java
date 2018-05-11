package com.vita.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.servlet.ServletRegistration;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by bobo on 2018/5/11.
 *
 * @email ruantianbo@163.com
 */
@Configuration
public class DruidConfig {
    //https://blog.csdn.net/hj7jay/article/details/51686418
    private static final Logger logger = LoggerFactory.getLogger(DruidConfig.class);

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.initialSize}")
    private Integer initialSize;

    @Value("${spring.datasource.maxActive}")
    private Integer maxActive;

    @Value("${spring.datasource.maxWait}")
    private Integer maxWait;

    @Value("${spring.datasource.filters}")
    private String filters;

    //配置 statView 用于展示统计数据
    @Bean
    public ServletRegistrationBean druidBean(){
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        reg.addInitParameter("loginUsername", "druid");
        reg.addInitParameter("loginPassword", "jiajian123456");
        return reg;
    }

    //配置 stat 用于统计数据库操作
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean frbean = new FilterRegistrationBean();
        frbean.setFilter(new WebStatFilter());
        frbean.addUrlPatterns("/*");
        frbean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        frbean.addInitParameter("profileEnable", "true");
        frbean.addInitParameter("principalCookieName", "USER_COOKIE");
        frbean.addInitParameter("principalSessionName", "USER_SESSION");
        return frbean;
    }


    @Bean(initMethod = "init",destroyMethod = "close")
    @Primary
    public DruidDataSource dataSource(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        datasource.setInitialSize(initialSize);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            logger.debug("init Druid error",e);
        }
        return datasource;
    }
}
