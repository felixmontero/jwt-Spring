package com.esliceu.jwt.controllers;

import com.esliceu.jwt.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;
@Controller
public class LoginController {

    TokenService tokenService;
      public LoginController(TokenService tokenService) {
        this.tokenService = tokenService;
      }

    @PostMapping("/login")
    public Map<String,String> login(String user,String password){
        if(user.equals("bill") && password.equals("gates")){
            String token = tokenService.newToken(user);
            System.out.println(token);
        }
        return null;
    }
}
