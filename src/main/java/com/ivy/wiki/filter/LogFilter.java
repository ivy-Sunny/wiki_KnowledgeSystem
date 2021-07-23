package com.ivy.wiki.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * LogFilter
 * 打印日志过滤器
 * @Author: ivy
 * @CreateTime: 2021-07-22
 */
@Component
public class LogFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(LogFilter.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //打印请求信息
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        LOG.info("—————————————LogFilter开始—————————————");
        LOG.info("请求地址：{} {}", request.getRequestURL().toString(), request.getMethod().toUpperCase());
        LOG.info("远程地址：{}", request.getRemoteAddr());

        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        LOG.info("—————————————LogFilter结束 耗时：{} ms—————————————", System.currentTimeMillis() - startTime);
    }

    @Override
    public void destroy() {

    }
}