package com.djcedblab.spring_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/static")
    public String home(){
        return "index2.html";
    }
}
