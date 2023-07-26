package com.mini.anuualwork.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Annual {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "status")
    private AnnualStatus status;

    @ManyToOne
    private Member member;
}
