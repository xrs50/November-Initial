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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
