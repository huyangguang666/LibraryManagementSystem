package com.myproject.bookmanager.controllers;

import com.myproject.bookmanager.biz.LoginBiz;
import com.myproject.bookmanager.model.User;
import com.myproject.bookmanager.utils.CookieUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private LoginBiz loginBiz;

//    @Autowired
//    private UserService userService;

    /**
     * 跳转到注册页面
     * @return
     */
    @GetMapping("/users/register")
    public String register(){
        return "login/register";
    }

    /**
     * 注册
     * @RequestParam model
     * @RequestParam response
     * @RequestParam name
     * @RequestParam email
     * @RequestParam password
     * @return
     */
    @PostMapping("/users/register/do")
    public String doRegister(
            Model model,
            HttpServletResponse response,
            @RequestParam ("name") String name,
            @RequestParam ("email") String email,
            @RequestParam ("password") String password){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        try {
            String t = loginBiz.register(user);
            CookieUtils.writeCookie("t", t, response);
            return "redirect:/index";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "404";
        }
    }

    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping("/users/login")
    public String login(){
        return "login/login";
    }

    /**
     * 登录
     * @param model
     * @param response
     * @param email
     * @param password
     * @return
     */
    @PostMapping("/users/login/do")
    public String doLogin(
            Model model,
            HttpServletResponse response,
            @Param("email") String email,
            @Param("password") String password){
        try {
            String t = loginBiz.login(email, password);
            CookieUtils.writeCookie("t", t, response);
            return "redirect:/index";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "404";
        }
    }

    @GetMapping("/users/logout/do")
    public String logout(@CookieValue("t") String t){
        loginBiz.logout(t);
        return "redirect:/index";
    }
}
