package org.example.shared.io.validation;

import java.util.Optional;
import java.util.function.Predicate;

public class NonBlankInputValidationRule implements InputValidationRule {
    @Override
    public boolean isValid(String input) {
        return Optional.ofNullable(input).filter(Predicate.not(String::isBlank)).isPresent();
    }
}
