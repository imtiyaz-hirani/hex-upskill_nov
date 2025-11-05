package com.hex.trs.service;

import com.hex.trs.dto.TicketReqDto;
import com.hex.trs.enums.Priority;
import com.hex.trs.enums.Status;
import com.hex.trs.mapper.TicketMapper;
import com.hex.trs.model.Customer;
import com.hex.trs.model.Ticket;
import com.hex.trs.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<Ticket> allTickets() {
        return ticketRepository.findAll();
    }

    public List<Ticket> allTickets(Integer page, Integer size) {
        Pageable pageable =  PageRequest.of(page,size);
        return ticketRepository.findAll(pageable).getContent();
    }

    public List<Ticket> getTicketsFilter(String priority, String status) {
        /* Filter 1: priority */
         List<Ticket> list = new ArrayList<>();

        if(!(priority.equals(""))){
            // Convert string into enum
            Priority priorityVal = Priority.valueOf(priority);
            // fetch tickets for this priority
            list = ticketRepository.findByPriority(priorityVal);
        }

        /* Filter 2: status */
        if(!(status.equals(""))){
            // Convert string into enum
            Status statusVal = Status.valueOf(status);
            // fetch tickets for this status
            if(list.isEmpty()){
                list = allTickets();
            }
            List<Long> idList = list.stream().map(Ticket :: getId).toList();

            list = ticketRepository.findByStatus(statusVal,idList);
        }

        return list;
    }
}
