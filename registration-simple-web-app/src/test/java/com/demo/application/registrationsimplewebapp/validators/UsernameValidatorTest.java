package com.demo.application.registrationsimplewebapp.validators;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UsernameValidatorTest {

    private static final String USERNAME_VALID = "TestUsername";

    private static final String USERNAME_INVALID_SHORTER = "UN";

    private static final String USERNAME_INVALID_NON_ALPHA = "UNAL~~";

    private final UsernameValidator validator = new UsernameValidator();

    @Test
    void testValidationWithValidUsername() {
        //when
        boolean result = validator.isValid(USERNAME_VALID, null);

        //then
        assertThat(result)
                .as("Should return true, for valid username")
                .isTrue();
    }

    @Test
    void testValidationWithTooShortUsername() {
        //when
        boolean result = validator.isValid(USERNAME_INVALID_SHORTER, null);

        //then
        assertThat(result)
                .as("Should return false, for invalid username")
                .isFalse();
    }

    @Test
    void testValidationWithNonAlphanumericUsername() {
        //when
        boolean result = validator.isValid(USERNAME_INVALID_NON_ALPHA, null);

        //then
        assertThat(result)
                .as("Should return false, for invalid username")
                .isFalse();
    }
}