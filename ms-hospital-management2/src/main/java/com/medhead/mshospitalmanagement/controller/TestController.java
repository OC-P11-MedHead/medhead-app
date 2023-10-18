package com.medhead.mshospitalmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    /**
    * Read - Get all employees
    * @return - String
    */
    @GetMapping("/employees")
    public String getEmployees() {
        return "bonjour";
    }
    
    /**
    * Read - e
    * @return - String
    */
    @GetMapping("/")
    public String home() {
        return "bonjour home";
    }
}