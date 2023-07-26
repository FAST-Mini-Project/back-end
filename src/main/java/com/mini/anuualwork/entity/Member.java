package com.mini.anuualwork.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "employeeNumber")
    private String employeeNumber;


    @Column(name = "memberRole")
    @Enumerated(EnumType.STRING)
    MemberRole memberRole;
}
