package org.example.jaystuff;

import org.example.jaystuff.model.PrimaryTeacher;
import org.example.jaystuff.model.Student;
import org.example.shared.io.UserInputService;
import org.example.shared.io.UserOutputService;
import org.example.shared.io.console.ConsoleUserInputServiceImpl;
import org.example.shared.io.console.ConsoleUserOutputServiceImpl;
import org.example.shared.io.validation.NonBlankInputValidationRule;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.Instant;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        UserOutputService userOutputService = new ConsoleUserOutputServiceImpl();
        try(UserInputService userInputService = new ConsoleUserInputServiceImpl(userOutputService)) {
            userOutputService.print("WELCOME");
            String response = userInputService.getUserInput("What's the student name?",
                    new NonBlankInputValidationRule());

            // create a new student instance
            Student student1 = new Student();
            student1.setId(3);
            student1.setName(response);
            student1.setDob(Date.from(Instant.now()));
            student1.setPrimaryTeacher(PrimaryTeacher.JAY);

            // create EntityManager (copy paste this when needed)
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            // access transaction object (copy paste this when needed)
            EntityTransaction transaction = entityManager.getTransaction();

            // create and use transactions (copy paste this when needed)
            transaction.begin();

            entityManager.persist(student1); // IMPORTANT!

            // commit your transaction (copy paste this when needed)
            transaction.commit();
        }
    }
}

enum Example {
    YES, NO
}