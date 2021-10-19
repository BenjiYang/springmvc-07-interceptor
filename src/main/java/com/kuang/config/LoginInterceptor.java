package com.kuang.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("++++++++++++++++++++++++++++++++++++++ LoginInterceptor.preHandle() 处理前 ++++++++++++++++++++++++++++++++++++++");

        // 如果视图请求的URI包含"toLogin"(跳转登陆)或者包含"login"(登陆提交)，则表明当前已经在登陆页面，或正在登陆提交，则继续往后proceed
        if (request.getRequestURI().contains("toLogin") || request.getRequestURI().contains("login")) {
            System.out.println("LoginInterceptor.preHandle() => 当前已经在Login页面");
            return true;
        }

        // 登陆后，model的attribute已经设置了"userLoginInfo"，已经带了session，继续往后proceed
        HttpSession session = request.getSession();
        if (session.getAttribute("userLoginInfo")!=null) {
            System.out.println("LoginInterceptor.preHandle() => 当前已经登陆有session");
            return true;
        }

        // 如果上面条件都没有匹配，则说明未登陆，且不在login相关页面，此时转发到login页面
        // 这里不能用重定向到/jsp目录下资源文件，但可以重定向到toLogin()）
        // 重定向是客户端级别但不能走WEB-INF里的页面
        System.out.println("LoginInterceptor.preHandle() => 您当前未登陆且不在Login页面，将让您回到登陆页面");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("++++++++++++++++++++++++++++++++++++++ LoginInterceptor.postHandle() 处理后 ++++++++++++++++++++++++++++++++++++++");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("++++++++++++++++++++++++++++++++++++++ LoginInterceptor/afterCompletion() 清理 ++++++++++++++++++++++++++++++++++++++");
    }
}
