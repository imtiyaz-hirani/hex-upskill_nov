package com.hex.trs.mapper;

import com.hex.trs.dto.TicketReqDto;
import com.hex.trs.enums.Priority;
import com.hex.trs.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public Ticket toEntity(TicketReqDto dto){
        Ticket ticket = new Ticket();
        ticket.setSubject(dto.subject());
        ticket.setIssue(dto.issue());
        //Convert String to Enum
        Priority priority = Priority.valueOf(dto.priority());
        ticket.setPriority(priority);
       return ticket;
    }
}
