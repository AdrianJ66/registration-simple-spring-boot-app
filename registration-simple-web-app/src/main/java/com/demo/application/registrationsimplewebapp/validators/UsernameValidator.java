package com.demo.application.registrationsimplewebapp.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<ValidUsername, String> {

    private static final String USERNAME_PATTERN = "^[_A-Za-z0-9]{5,}$";

    private static final Pattern PATTERN = Pattern.compile(USERNAME_PATTERN);

    @Override
    public boolean isValid(final String username, final ConstraintValidatorContext context) {
        return validateUsername(username);
    }

    private boolean validateUsername(final String username) {
        if (username == null) {
            return false;
        }

        Matcher matcher = PATTERN.matcher(username);
        return matcher.matches();
    }
}
