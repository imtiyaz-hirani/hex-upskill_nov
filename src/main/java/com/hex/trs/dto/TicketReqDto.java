package com.hex.trs.dto;

import com.hex.trs.enums.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TicketReqDto(
        @NotNull(message = "subject cannot be null")
        @NotBlank(message = "subject needs a value")
        @Size(max = 255,message = "subject should be less than 255 characters")
        String subject,
        @NotNull(message = "issue cannot be null")
        @NotBlank(message = "issue needs a value")
        @Size(max = 255,message = "issue should be less than 1000 characters")
        String issue,
        @NotNull(message = "priority cannot be null")
        @NotBlank(message = "priority needs a value")
        String priority
) {
}