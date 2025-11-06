package com.hex.trs.dto;

public record PlanDto(
        long planId,
        String planName,
        double price,
        long numberOfCustomers
) {
}
