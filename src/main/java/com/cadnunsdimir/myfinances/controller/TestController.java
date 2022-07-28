package com.cadnunsdimir.myfinances.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/api/status")
    public String status() {
        return "OK";
    }
}
