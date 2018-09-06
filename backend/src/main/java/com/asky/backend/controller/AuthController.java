package com.asky.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {

//    @CrossOrigin(allowedHeaders = "",allowCredentials = "true")
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
