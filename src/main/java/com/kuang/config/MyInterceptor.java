package com.kuang.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    /**
     *
     *   @return {@code true} if the execution chain should proceed with the
     * 	 * next interceptor or the handler itself. Else, DispatcherServlet assumes
     * 	 * that this interceptor has already dealt with the response itself.
     *
     * 	 return true; 执行下一个拦截器（放行）
     * 	 return false; 不执行下一个拦截器，甚至连后面的controller也没有执行，将卡在此处，后续操作不执行
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("============== MyInterceptor.preHandle() 处理前 ==============");
        return true; // return true后执行下一个interceptor
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("============== MyInterceptor.postHandle() 处理后 ==============");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("============== MyInterceptor/afterCompletion() 清理 ==============");
    }
}
