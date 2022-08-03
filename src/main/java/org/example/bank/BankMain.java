package org.example.bank;

import org.example.bank.db.BankAccountRepository;
import org.example.bank.model.BankAccount;
import org.example.bank.service.BankAccountService;
import org.example.bank.service.BankAccountServiceImplementation;
import org.example.shared.io.UserInputService;
import org.example.shared.io.UserOutputService;
import org.example.shared.io.console.ConsoleUserInputServiceImpl;
import org.example.shared.io.console.ConsoleUserOutputServiceImpl;
import org.example.shared.io.validation.NonBlankInputValidationRule;

public class BankMain {
    public static void main(String[] args) {

        UserOutputService userOutputService = new ConsoleUserOutputServiceImpl();
        BankAccountRepository bankAccountRepository = new BankAccountRepository();
        BankAccountService implementation = new BankAccountServiceImplementation(bankAccountRepository);

        try (UserInputService userInputService = new ConsoleUserInputServiceImpl(userOutputService)) {
            userOutputService.print("WELCOME TO THE SEAN-JUAN BANK");

            boolean processing = true;
            while (processing) {

                // TODO: getUserChoice("Question", 1,2,3);
                int createOrChoose = Integer.parseInt(userInputService.getUserInput("ENTER [1] to CREATE a new bank account \nENTER [2] to CHOOSE an existing bank account to deposit or withdraw\nENTER [3] to exit out of the program",
                        new NonBlankInputValidationRule()));


                switch (createOrChoose) {
                    case 1: // create
                        String name = userInputService.getUserInput("What's the user's name?",
                                new NonBlankInputValidationRule());

                        String address = userInputService.getUserInput("What's the user's address?",
                                new NonBlankInputValidationRule());

                        Double initialDeposit = Double.valueOf(userInputService.getUserInput("What's the user's deposit?",
                                new NonBlankInputValidationRule()));

                        BankAccount bankAccountToCreate = new BankAccount();
                        bankAccountToCreate.setName(name);
                        bankAccountToCreate.setAddress(address);
                        bankAccountToCreate.setBalance(initialDeposit);
                        bankAccountRepository.save(bankAccountToCreate);
                        break;
                    case 2: // choose
                        int lookupID = Integer.parseInt(userInputService.getUserInput("Enter ID of the bank account user",
                                new NonBlankInputValidationRule()));

                        int choice = Integer.parseInt(userInputService.getUserInput("Enter [1] to deposit \nEnter [2] to withdraw",
                                new NonBlankInputValidationRule()));

                        switch (choice) {
                            case 1: // deposit
                                Double depositAmount = Double.valueOf(userInputService.getUserInput("How much do you want to deposit?",
                                        new NonBlankInputValidationRule()));
                                implementation.deposit(lookupID, depositAmount);
                                break;
                            case 2: // withdraw
                                Double withdrawAmount = Double.valueOf(userInputService.getUserInput("How much do you want to withdraw?",
                                        new NonBlankInputValidationRule()));
                                implementation.withdraw(lookupID, withdrawAmount);
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("Bank is closed for the day");
                        processing = false;
                        System.exit(0);
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
