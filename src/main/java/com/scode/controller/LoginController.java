package com.scode.controller;

import com.scode.com.LoginDetails;
import com.scode.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> login(@RequestBody LoginDetails user) {

        var userDetails = userDetailsService.loadUserByUsername(user.getUserId());
        var token = jwtService.generateToken(userDetails);

        return Map.of("jwt", token, "tokenType", "Bearer");
    }

}
