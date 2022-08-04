package org.example.bank.service;

public interface BankAccountService {

    double deposit(int id, double amount);

    double withdraw(int id, double amount);

    // TODO: also make createAccount(), transferBalance(),  checkBalance() method
    void transfer(int transferFrom, int transferTo, double amount);

    double checkBalance(int id);
}
