package com.ivy.wiki.config;

import com.ivy.wiki.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * SpringMvcConfig
 *
 * @Author: ivy
 * @CreateTime: 2021-07-23
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Resource
    LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(logInterceptor)
                .addPathPatterns("/**");
    }

}
