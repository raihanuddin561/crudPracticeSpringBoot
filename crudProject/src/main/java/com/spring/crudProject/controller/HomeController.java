package com.spring.crudProject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String helloWorld(){
        return "Welcome to BJIT as a software";
    }
}
