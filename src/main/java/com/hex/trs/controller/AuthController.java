package com.hex.trs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

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
}
