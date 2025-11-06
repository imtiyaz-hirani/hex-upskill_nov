package com.hex.trs.service;

import com.hex.trs.model.Customer;
import com.hex.trs.model.CustomerPlan;
import com.hex.trs.model.Plan;
import com.hex.trs.repository.CustomerPlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerPlanService {

    private final CustomerService customerService;
    private final PlanService planService;
    private final CustomerPlanRepository customerPlanRepository;

    public void addCustomerPlan(long customerId, long planId) {
        // Step 1: Fetch Customer Obj using given customerId
        Customer customer = customerService.getById(customerId);

        // Step 2: Fetch Plan Obj using given planId
        Plan plan = planService.getById(planId);

        // Step 3: Attach customer and plan obj to CustomerPlan Obj
        CustomerPlan customerPlan = new CustomerPlan();
        customerPlan.setCustomer(customer);
        customerPlan.setPlan(plan);

        // Step 4: Set metadata if any

        // Step 5: Save this CustomerPlan model in DB
        customerPlanRepository.save(customerPlan);
        // Note: If Ids are invalid, throw InvalidIdException and handle them globally
    }
}
