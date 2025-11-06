package com.hex.trs.dto;

import com.hex.trs.enums.Priority;
import com.hex.trs.enums.Status;

import java.time.Instant;

public record TicketResDto(
        long customerId,
        String customerName,
        Priority priority,
        Status status,
        Instant createdAt,
        String executiveName
) {
}
