package com.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {

    @RequestMapping("/")
    @ResponseBody
    String index() {
        return "Welcome to data-access and transaction in Spring";
    }
}
