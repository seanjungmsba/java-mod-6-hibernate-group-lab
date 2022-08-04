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

        // TODO: The user can see a record of all deposits and withdrawals and transfers from their accounts.

        UserOutputService userOutputService = new ConsoleUserOutputServiceImpl();
        BankAccountRepository bankAccountRepository = new BankAccountRepository();
        BankAccountService implementation = new BankAccountServiceImplementation(bankAccountRepository);

        try (UserInputService userInputService = new ConsoleUserInputServiceImpl(userOutputService)) {
            userOutputService.print("WELCOME TO THE SEAN-JUAN BANK");

            boolean processing = true;
            while (processing) {

                int createOrChoose = Integer.parseInt(userInputService.getUserInput("ENTER [1] to CREATE a new bank account \nENTER [2] to CHOOSE an existing bank account to deposit, withdraw, transfer, or check balance\nENTER [3] to exit out of the program",
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

                        int choice = Integer.parseInt(userInputService.getUserInput("Enter [1] to deposit \nEnter [2] to withdraw \nEnter [3] to transfer \nEnter [4] to check balance",
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
                            case 3: // transfer
                                int receiverID = Integer.parseInt(userInputService.getUserInput("Enter ID of the bank account user who will receive the transfer",
                                        new NonBlankInputValidationRule()));
                                if (receiverID == lookupID) {
                                    userOutputService.print("You cannot make transfer within the same account!");
                                    break;
                                }
                                Double transferAmount = Double.valueOf(userInputService.getUserInput("How much do you want to transfer?",
                                        new NonBlankInputValidationRule()));
                                implementation.transfer(lookupID, receiverID, transferAmount);
                                break;
                            case 4: // check balance
                                userOutputService.print("Available balance: $" + implementation.checkBalance(lookupID));
                                break;
                        }
                        break;
                    case 3:
                        userOutputService.print("Bank is closed for the day");
                        processing = false;
                        System.exit(0);
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
