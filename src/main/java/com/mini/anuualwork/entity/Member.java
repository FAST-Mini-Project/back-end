package com.mini.anuualwork.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "employeeNumber")
    private String employeeNumber;

    @Enumerated(EnumType.STRING)
    MemberRole memberRole;


}
