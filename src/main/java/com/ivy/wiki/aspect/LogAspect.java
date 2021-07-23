package com.ivy.wiki.aspect;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.PropertyPreFilters;
import com.ivy.wiki.filter.LogFilter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * LogAspect
 * AOP打印日志
 *
 * @Author: ivy
 * @CreateTime: 2021-07-23
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger LOG = LoggerFactory.getLogger(LogFilter.class);

    /**
     * 定义一个切点
     */
    @Pointcut("execution(public * com.ivy.*.controller..*Controller.*(..))")
    public void controllerPointCut() {
    }

    ;

    @Before("controllerPointCut()")
    public void doBefore(JoinPoint joinPoint) {

        //开始打印请求日志
        ServletRequestAttributes attributes
                = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Signature signature = joinPoint.getSignature();

        //打印请求信息
        LOG.info("—————————————LogAspect开始—————————————");
        LOG.info("请求地址：{} {}", request.getRequestURL().toString(), request.getMethod().toUpperCase());
        LOG.info("类名方法：{}.{}", signature.getDeclaringTypeName(), signature.getName());
        LOG.info("远程地址：{}", request.getRemoteAddr());

        //打印请求参数
        Object[] args = joinPoint.getArgs();
        Object[] arguments = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest
                    || args[i] instanceof ServletResponse
                    || args[i] instanceof MultipartFile) {
                continue;
            }
            arguments[i] = args[i];
        }
        //排除字段，敏感字段或太长的字段不显示
        String[] excludeProperties = {"PASSWORD", "FILE"};
        PropertyPreFilters filters = new PropertyPreFilters();
        PropertyPreFilters.MySimplePropertyPreFilter excludefilter = filters.addFilter();
        excludefilter.addExcludes(excludeProperties);
        LOG.info("请求参数：{}", JSONObject.toJSONString(args));
    }

    @Around("controllerPointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        LOG.info("请求参数：{}", JSONObject.toJSONString(result));
        LOG.info("—————————————LogAspect结束 耗时：{} ms—————————————", System.currentTimeMillis() - startTime);
        return result;
    }
}
