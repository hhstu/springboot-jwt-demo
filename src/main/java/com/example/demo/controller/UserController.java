package com.example.demo.controller;

import com.example.demo.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/users")
    public String users(HttpServletRequest request) {
        return request.getAttribute("username").toString();
    }
    @GetMapping("/login")
    public String login() {
        //return "666";
        return JwtUtils.generateToken("lc");
    }

}
