package com.demo.application.registrationsimplewebapp.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.demo.application.registrationsimplewebapp.dto.UserDto;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        final UserDto user = (UserDto) object;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
