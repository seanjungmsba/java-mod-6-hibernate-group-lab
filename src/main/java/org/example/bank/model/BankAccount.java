package org.example.bank.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Setter
@Getter
@Entity
public class BankAccount {
    @Id
    private int id;
}
