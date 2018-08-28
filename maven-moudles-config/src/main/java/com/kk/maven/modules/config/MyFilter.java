package com.kk.maven.modules.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author :Mr.kk
 * @date: 2018/8/27-14:04
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器加载成功！=======================》");
    }

    /** 过滤器真正工作的方法
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getRequestURI();
        System.out.println("当前的访问的接口为："+ url);
        //将请求转发给下一个过滤链，如果没有filter那就是你请求的资源
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.print("过滤器销毁成功！=======================》");
    }
}
