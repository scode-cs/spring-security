package com.scode.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearerAuth")
public class AppController {


    @GetMapping("/user")
    public Map<String, String> user() {
        return Map.of("message", "Welcome User!!");
    }

    @GetMapping("/admin")
    public Map<String, String> admin() {
        return Map.of("message", "Welcome Admin!!");
    }
}
