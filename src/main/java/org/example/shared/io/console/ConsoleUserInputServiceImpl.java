package org.example.shared.io.console;

import org.example.shared.io.UserInputService;
import org.example.shared.io.UserOutputService;
import org.example.shared.io.validation.InputValidationRule;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConsoleUserInputServiceImpl implements UserInputService {

    private Scanner scanner;
    private UserOutputService userOutputService;

    public ConsoleUserInputServiceImpl(UserOutputService userOutputService) {
        this.scanner = new Scanner(System.in);
        this.userOutputService = userOutputService;
    }

    @Override
    public String getUserInput(String prompt, InputValidationRule... rules) {
        userOutputService.print(prompt);
        String response = scanner.nextLine();
        if (rules.length > 0 && Stream.of(rules).noneMatch(rule -> rule.isValid(response))) {
            userOutputService.print("Please enter valid input");
            return getUserInput(prompt, rules);
        }
        return response;
    }

    @Override
    public <T> T getUserChoice(String prompt, T... options) {
        StringBuilder promptSB = new StringBuilder(prompt);
        for (int i = 0; i < options.length; i++) {
            promptSB.append("\n\t").append(i).append(": ").append(options[i].toString());
        }
        InputValidationRule selectedRealOption = (str) -> IntStream.range(0, options.length).mapToObj(i -> String.valueOf(i).trim()).anyMatch(i -> str.equals(i));
        String response = getUserInput(promptSB.toString(), selectedRealOption);
        return options[Integer.parseInt(response.trim())];
    }

    @Override
    public void close() throws Exception {
        scanner.close();
    }
}
