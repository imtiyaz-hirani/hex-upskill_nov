package com.hex.trs.repository;

import com.hex.trs.model.CustomerPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerPlanRepository extends JpaRepository<CustomerPlan, Long> {
}
