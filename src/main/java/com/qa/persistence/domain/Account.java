package com.qa.persistence.domain;

import javax.persistence.*;

@Entity
public class Account {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(length = 100)
    private String firstName;
    @Column(length = 100)
    private String lastName;
    @Column(length = 10)
    private int accountNumber;


}
