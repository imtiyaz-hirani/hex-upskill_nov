package com.hex.trs.service;

import com.hex.trs.exception.InvalidIdException;
import com.hex.trs.model.Plan;
import com.hex.trs.repository.PlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    public Plan getById(long planId) {
        return planRepository.findById(planId)
                .orElseThrow(()->new InvalidIdException("Plan Id Invalid"));
    }
}
