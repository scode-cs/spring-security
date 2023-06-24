package com.scode.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AppController {

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of("message", "Welcome!!");
    }

    @GetMapping("/user")
    public Map<String, String> user() {
        return Map.of("message", "Welcome User!!");
    }

    @GetMapping("/admin")
    public Map<String, String> admin() {
        return Map.of("message", "Welcome Admin!!");
    }
}
