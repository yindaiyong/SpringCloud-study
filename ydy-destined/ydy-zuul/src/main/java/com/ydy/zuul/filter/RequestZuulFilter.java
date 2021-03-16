package com.ydy.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Map;

@Component
public class RequestZuulFilter extends ZuulFilter {

    private static Logger LOGGER = LoggerFactory.getLogger(RequestZuulFilter.class);

    /**
     * 网关类型
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 网关优先级
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否开启
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤逻辑
     */
    @Override
    public Object run() throws ZuulException {

        LocalDateTime currentTime = LocalDateTime.now();

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        //获取客户端操作系统
        String os = userAgent.getOperatingSystem().getName();
        //获取客户端浏览器
        String browser = userAgent.getBrowser().getName();
        //用戶
        Object user = request.getSession().getAttribute("ydy-user");
        //請求地址
        String url = request.getRequestURL().toString();
        //請求頭
        String header = request.getHeader("ydy-token");
        //请求参数
        Map<String,String[]> paramMap = request.getParameterMap();
        LOGGER.info("用户{}，在{}，使用{}操作系统，{}浏览器，发起{}请求，请求头为{}，请求参数为{}",
                user,currentTime,os,browser,url,header,paramMap);
        return null;
    }
}
