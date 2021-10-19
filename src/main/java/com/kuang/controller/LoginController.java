package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller // 此处必须是Controller，因为控制到视图
public class LoginController {

    @RequestMapping("/toMain")
    public String toMain() {
        System.out.println("LoginController => toMain()");
        return "main";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        System.out.println("LoginController => toLogin()");
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password) { // 此处没有传user对象，用hard coded调试
        System.out.println("LoginController => login()");
        // 登陆后把用户的信息存在session中
        session.setAttribute("userLoginInfo", username);
        return "main";
    }
}
