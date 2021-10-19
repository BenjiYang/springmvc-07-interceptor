package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller // 此处必须是Controller，因为控制到视图
@RequestMapping("/user")
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
    public String login(HttpSession session, String username, String password, Model model) { // 此处没有传user对象，用hard coded调试
        System.out.println("LoginController => login()");
        // 登陆后把用户的信息存在session中
        session.setAttribute("userLoginInfo", username);
        model.addAttribute("username", username);
        return "main";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, String username, String password, Model model) { // 此处没有传user对象，用hard coded调试
        System.out.println("LoginController => logout()");
        // 登陆后把用户的信息存在session中
//        session.removeAttribute("userLoginInfo");
        session.setAttribute("userLoginInfo", null);
        return "login";
    }
}
