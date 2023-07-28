package com.mini.anuualwork.entity;

import com.mini.anuualwork.entity.type.AnnualStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Annual {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AnnualStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}