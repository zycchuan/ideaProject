package com.zyc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("me")
public class LoginController {

    @RequestMapping("login")
    public  String login(String username){

        System.out.println(username);
        return "/login/loginSuccess";
    }
}
