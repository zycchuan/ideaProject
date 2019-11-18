package com.zyc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器
public class MyInterceptor implements HandlerInterceptor {
    //进入到controller方法之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandle.....");
        //可以在这里 判断登录
        return HandlerInterceptor.super.preHandle(request,response,handler);

    }
    //进入controller 方法之后  视图渲染之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...");
        String username = request.getParameter("username");
        System.out.println(username+"  posthandle");
        HandlerInterceptor.super.postHandle(request,response,handler,modelAndView);
    }
    //整个 请求响应 完成之后  通常用于 资源的清理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
        HandlerInterceptor.super.afterCompletion(request,response,handler,ex);
    }
}
