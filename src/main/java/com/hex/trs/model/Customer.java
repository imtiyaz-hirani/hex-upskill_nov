package com.hex.trs.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cty;

    @OneToOne
    private User user;

//    @ManyToMany
//    @JoinTable(name = "customer_plan")
//    private List<Plan> plans; //p1 p2 p3

}
// int x = 6 7 8 9
// List<Integer> list ={6,7,8,9}