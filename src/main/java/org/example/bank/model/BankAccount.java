package org.example.bank.model;

import lombok.Getter;
import lombok.Setter;
import org.example.bank.service.BankAccountService;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Table
@Setter
@Getter
@Entity
public class BankAccount implements BankAccountService {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String address;

    private double balance;

    public double deposit(double amount) {
        this.balance += amount;
        return this.balance;
    }

    public double withdraw(double amount) {
        if (balance >= amount)
            this.balance -= amount;
        return this.balance;
    }

}
