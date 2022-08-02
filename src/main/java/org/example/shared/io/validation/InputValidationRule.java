package org.example.shared.io.validation;

@FunctionalInterface
public interface InputValidationRule {
    boolean isValid(String input);
}
