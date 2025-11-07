package com.hex.trs.controller;

import com.hex.trs.model.User;
import com.hex.trs.service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/public/hello")
    public String sayHello(){
        return "Hello Public!!!";
    }

    @GetMapping("/user/hello")
    public String sayHelloTOUser(Principal principal){
       String username =  principal.getName();
       return "Hello Registered User--  " + username;
    }

    @GetMapping("/customer/hello")
    public String sayHelloToCustomer(Principal principal){
        return "Hello Customer!! " + principal.getName();
    }

    @GetMapping("/executive/hello")
    public String sayHelloToExecutive(Principal principal){
        return "Hello Executive!! " + principal.getName();
    }

    @GetMapping("/login")
    public User login(Principal principal){
        String username = principal.getName();
        User user  = (User) userService.loadUserByUsername(username);
        return user;
    }
}
