package com.lena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName SecurityController
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/10/10 15:25
 * @Version 1.0
 */
@Controller
public class SecurityController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
