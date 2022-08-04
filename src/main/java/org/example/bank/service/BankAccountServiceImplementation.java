package org.example.bank.service;

import org.example.bank.db.BankAccountRepository;
import org.example.bank.model.BankAccount;

public class BankAccountServiceImplementation implements BankAccountService {

    private final BankAccountRepository repository;

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

    @Override
    public void transfer(int transferFrom, int transferTo, double amount) {
        // we retrieve the bank account that sends money
        BankAccount sender = repository.findById(transferFrom).get();
        // we retrieve the bank account that receives money
        BankAccount receiver = repository.findById(transferTo).get();
        // where we determine how much bank account balance is on sender account after transfer
        double afterTransferBalanceSender = sender.getBalance() - amount;
        // where we determine how much bank account balance is on receiver account after transfer
        double afterTransferBalanceReceiver = receiver.getBalance() + amount;
        // setting the balance based on the previous field
        sender.setBalance(afterTransferBalanceSender);
        receiver.setBalance(afterTransferBalanceReceiver);
        System.out.println(amount + " is successfully transferred from " + sender.getName() + "'s account to " + receiver.getName() + "'s account");
        // save the updated information to the repository
        repository.save(sender);
        repository.save(receiver);
    }

    @Override
    public double checkBalance(int id) {
        BankAccount bankAccount = repository.findById(id).get();
        return bankAccount.getBalance();
    }
}
