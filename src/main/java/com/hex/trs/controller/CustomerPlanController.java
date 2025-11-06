package com.hex.trs.controller;

import com.hex.trs.service.CustomerPlanService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/customer/plan")
@AllArgsConstructor
public class CustomerPlanController {

    private final CustomerPlanService customerPlanService;

    @PostMapping("/add/{customerId}/{planId}")
    public ResponseEntity<?> addCustomerPlan(
            @PathVariable long customerId,
            @PathVariable long planId
    ){
        customerPlanService.addCustomerPlan(customerId,planId);
        return ResponseEntity
                .created(URI.create(""))
                .body("Plan Registered!!");
    }
}
