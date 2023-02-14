package com.esliceu.jwt.controllers;

import com.esliceu.jwt.services.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
@RestController
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
            Map<String,String> map = new HashMap<>();
            map.put("token",token);
            return map;
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Bad credentials");
    }
    @GetMapping("/private")
    public String test(HttpServletRequest request){

        String username = (String) request.getAttribute("user");
        return username;
    }
}
