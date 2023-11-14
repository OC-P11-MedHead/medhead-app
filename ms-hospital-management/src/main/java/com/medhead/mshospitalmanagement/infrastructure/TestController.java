package com.medhead.mshospitalmanagement.infrastructure;

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
        return "bonjour les employés chef ";
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