package com.gdsc.letsgomvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PracticeController {

    @GetMapping("/dabin/babo")
    @ResponseBody
    public static String dabinBabo(@RequestParam("name") String name){
        return "hello" + name;
    }
}
