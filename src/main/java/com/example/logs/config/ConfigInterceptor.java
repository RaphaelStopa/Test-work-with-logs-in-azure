package com.example.logs.config;

import lombok.Data;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ConfigInterceptor {

    public static final String DEFAULT_HEADER_TOKEN = "correlationId";
    public static final String DEFAULT_MDC_UUID_TOKEN_KEY = "correlationId";

    private String responseHeader = DEFAULT_HEADER_TOKEN;
    private String mdcKey = DEFAULT_MDC_UUID_TOKEN_KEY;
    private String requestHeader = DEFAULT_HEADER_TOKEN;

    @Bean
    public FilterRegistrationBean<LogInterceptor> servletRegistrationBean() {
        final FilterRegistrationBean<LogInterceptor> registrationBean = new FilterRegistrationBean<>();
        final LogInterceptor log4jMDCFilterFilter = new LogInterceptor(responseHeader, mdcKey, requestHeader);
        registrationBean.setFilter(log4jMDCFilterFilter);
        registrationBean.setOrder(2);
        return registrationBean;
    }

}