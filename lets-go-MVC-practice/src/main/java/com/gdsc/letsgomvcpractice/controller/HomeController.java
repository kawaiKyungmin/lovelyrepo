package com.gdsc.letsgomvcpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")//mvc템플릿 엔진
    public String home(){
        return "home";
    }
}
