package org.example.bank.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Setter
@Getter
@Entity
public class BankAccount {

    // Comment: Plain Old Java Object (POJO) should not implement anything
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String address;

    private double balance;

}
