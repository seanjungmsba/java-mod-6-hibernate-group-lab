package org.example.bank.service;

import org.example.bank.db.BankAccountRepository;
import org.example.bank.model.BankAccount;

public class BankAccountServiceImplementation implements BankAccountService {

    private BankAccountRepository repository;

    public BankAccountServiceImplementation(BankAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public double deposit(int id, double amount) {
        // we retrieve the bank account by its id
        BankAccount bankAccount = repository.findById(id).get();
        // where we determine how much bank account balance is after deposit
        double afterDepositBalance = bankAccount.getBalance() + amount;
        // setting the balance based on the previous field
        bankAccount.setBalance(afterDepositBalance);
        // save the updated information to the repository
        repository.save(bankAccount);
        // printing the balance
        return bankAccount.getBalance();
    }

    @Override
    public double withdraw(int id, double amount) {
        // we retrieve the bank account by its id
        BankAccount bankAccount = repository.findById(id).get();
        // where we determine how much bank account balance is after deposit
        double afterWithdrawBalance = bankAccount.getBalance() - amount;
        // setting the balance based on the previous field
        bankAccount.setBalance(afterWithdrawBalance);
        // save the updated information to the repository
        repository.save(bankAccount);
        // printing the balance
        return bankAccount.getBalance();
    }
}
