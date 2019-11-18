package com.zyc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//过滤器
@WebFilter(urlPatterns = "/me/*") //过滤的请求
public class LoginFilter implements Filter {
    //容器加载的时候调用
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter init.....");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter doFilter.....");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String username = req.getParameter("username");
        System.out.println("filter"+username);
        if (username != null){
            filterChain.doFilter(servletRequest,servletResponse); //放行
        }else {

            resp.sendRedirect("../index.html");
        }

    }
    //容器销毁的时候调用
    @Override
    public void destroy() {
        System.out.println("MyFilter destroy.....");
    }
}
