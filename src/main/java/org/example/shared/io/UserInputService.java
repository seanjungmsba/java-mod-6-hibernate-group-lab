package org.example.shared.io;

import org.example.shared.io.validation.InputValidationRule;

public interface UserInputService extends AutoCloseable {
    String getUserInput(String prompt, InputValidationRule... rules);
    <T> T getUserChoice(String prompt, T... options);
}
