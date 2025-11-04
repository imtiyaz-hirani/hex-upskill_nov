package com.hex.trs.service;

import com.hex.trs.dto.TicketReqDto;
import com.hex.trs.enums.Status;
import com.hex.trs.mapper.TicketMapper;
import com.hex.trs.model.Customer;
import com.hex.trs.model.Ticket;
import com.hex.trs.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketService {

    private final TicketMapper ticketMapper;
    private final TicketRepository ticketRepository;
    private final  CustomerService customerService;

    public Ticket add(long customerId, TicketReqDto ticketReqDto) {
        // Check if this customer ID is valid and fetch Customer from DB
        Customer customer = customerService.getById(customerId);
        //convert Dto to Entity using mapper
        Ticket ticket = ticketMapper.toEntity(ticketReqDto);
        ticket.setStatus(Status.OPEN);

        //attach customer to ticket
        ticket.setCustomer(customer);
        //save the ticket
        return ticketRepository.save(ticket);
    }
}
