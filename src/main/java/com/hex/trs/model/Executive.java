package com.hex.trs.model;

import com.hex.trs.enums.JobTitle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "executives")
@Getter
@Setter
@NoArgsConstructor
public class Executive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;


}
