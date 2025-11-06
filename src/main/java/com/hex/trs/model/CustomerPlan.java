package com.hex.trs.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "customer_plan")
@Getter
@Setter
@NoArgsConstructor
public class CustomerPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Instant startedAt;

    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Plan plan;
}
