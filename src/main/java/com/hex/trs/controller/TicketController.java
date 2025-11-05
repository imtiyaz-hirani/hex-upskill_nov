package com.hex.trs.controller;

import com.hex.trs.service.TicketService;
import com.hex.trs.dto.TicketReqDto;
import com.hex.trs.model.Ticket;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public List<Ticket> getTickets(@RequestParam(name="size",required = false,defaultValue = "100000") Integer size ,
                                   @RequestParam(name="page", required = false, defaultValue = "0") Integer page  ){
       return ticketService.allTickets(page,size);
    }

    @GetMapping("/filter")
    public List<Ticket> getTicketsFilter(@RequestParam(required = false, defaultValue = "") String priority ,
                                 @RequestParam(required = false,defaultValue = "") String status){
        return ticketService.getTicketsFilter(priority,status);
    }
}
