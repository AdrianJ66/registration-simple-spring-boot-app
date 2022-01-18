package com.demo.application.registrationsimplewebapp.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return validatePassword(password);
    }

    private boolean validatePassword(String password) {
        int count = 0;

        if (password.length() < 8) {
            return false;
        }

        if (password.matches(".*\\d.*"))
            count++;

        if (password.matches(".*[a-z].*"))
            count++;

        if (password.matches(".*[A-Z].*"))
            count++;

        return count == 3;
    }
}
