package com.demo.application.registrationsimplewebapp.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.demo.application.registrationsimplewebapp.services.UserService;

public class UsernameUniquenessValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserService userService;

    public UsernameUniquenessValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return isUsernameUnique(username);
    }

    private boolean isUsernameUnique(String username) {
        return !userService.userWithGivenUsernameExists(username);
    }
}
