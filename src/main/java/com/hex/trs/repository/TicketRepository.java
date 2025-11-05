package com.hex.trs.repository;

import com.hex.trs.enums.Priority;
import com.hex.trs.enums.Status;
import com.hex.trs.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByPriority(Priority priorityVal);

    @Query("""
            select t
            from Ticket t
            where t.status=?1 AND t.id IN ?2
            """)
    List<Ticket> findByStatus(Status statusVal, List<Long> idList);
}
