package com.hex.trs.controller;

import com.hex.trs.service.TicketService;
import com.hex.trs.dto.TicketReqDto;
import com.hex.trs.model.Ticket;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/ticket")
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/add/{customerId}")
    public Ticket addTicket(@PathVariable long customerId,
                            @Valid @RequestBody TicketReqDto ticketReqDto){

        return ticketService.add(customerId, ticketReqDto);

    }
}
