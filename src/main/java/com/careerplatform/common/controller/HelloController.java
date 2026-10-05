package com.careerplatform.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/v1/hello")
    public String hello() {
        return "Career Platform API is running";
    }
}