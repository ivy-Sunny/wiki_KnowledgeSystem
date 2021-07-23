package com.ivy.wiki.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CorsConfig
 *
 * @Author: ivy
 * @CreateTime: 2021-07-22
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    /**
     * 配置跨域
     *wikidev@RDS
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /*对应路径*/
        registry.addMapping("/**")
                /*来源*/
                .allowedOriginPatterns("*")
                /*请求头*/
                .allowedHeaders(CorsConfiguration.ALL)
                /*请求方式*/
                .allowedMethods(CorsConfiguration.ALL)
                /*允许携带cookie*/
                .allowCredentials(true)
                /*1小时内不需要再预检（发送OPTIONS请求）*/
                .maxAge(3600);
    }
}
