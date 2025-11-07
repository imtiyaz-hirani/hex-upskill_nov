package com.hex.trs.controller;

import com.hex.trs.dto.CustomerDto;
import com.hex.trs.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody CustomerDto customerDto){
        customerService.signUp(customerDto);
        return ResponseEntity.created(URI.create("")).body("Customer SignUp Success");
    }

}
