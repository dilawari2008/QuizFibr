package com.example.Quiz.module.user.auth;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @Autowired
    private UserAuthService userAuthService;

    @PostMapping("/login")
    public String getToken(@RequestParam("username") final String username, @RequestParam("password") final String password){
        String token= userAuthService.login(username,password);
        if(StringUtils.isEmpty(token)){
            return "user not found, create user";
        }
        return token;
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") final String username, @RequestParam("password") final String password, @RequestParam String name){
        String token= userAuthService.register(username,password,name);
        if(StringUtils.isEmpty(token)){
            return "no token found, retry with another user";
        }
        return token;
    }
}
