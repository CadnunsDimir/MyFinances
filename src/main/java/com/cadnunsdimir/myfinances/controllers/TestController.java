package com.cadnunsdimir.myfinances.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/api/status")
    public String status() {
        return "OK";
    }
}
