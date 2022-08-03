package org.example.bank.db;

import org.example.bank.model.BankAccount;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Optional;

public class BankAccountRepository {//implements Repository<BankAccount> {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final EntityTransaction transaction = entityManager.getTransaction();

    //    @Override
    public BankAccount save(BankAccount bankAccount) { // saving a bank account to a database

        transaction.begin();
        entityManager.persist(bankAccount); // IMPORTANT!
        transaction.commit();
        return bankAccount;
    }

    //    @Override
    public Optional<BankAccount> findById(int id) {
        BankAccount bankAccount = entityManager.find(BankAccount.class, id);
        return Optional.ofNullable(bankAccount);
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public EntityTransaction getTransaction() {
        return transaction;
    }
}
