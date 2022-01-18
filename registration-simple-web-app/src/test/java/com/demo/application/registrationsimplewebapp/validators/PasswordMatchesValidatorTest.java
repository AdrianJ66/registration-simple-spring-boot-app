package com.demo.application.registrationsimplewebapp.validators;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.application.registrationsimplewebapp.dto.UserDto;

@ExtendWith(MockitoExtension.class)
class PasswordMatchesValidatorTest {

    private static final String USERNAME = "TestUsername";

    private static final String PASSWORD_1 = "TestPass1";

    private static final String PASSWORD_2 = "TestPass2";

    private final PasswordMatchesValidator validator = new PasswordMatchesValidator();

    @Test
    void testValidationWithMatchingPasswords() {
        //given
        UserDto user = new UserDto();
        user.setUsername(USERNAME);
        user.setPassword(PASSWORD_1);
        user.setMatchingPassword(PASSWORD_1);

        //when
        boolean result = validator.isValid(user, null);

        //then
        assertThat(result)
                .as("Should return true, for matching passwords")
                .isTrue();
    }

    @Test
    void testValidationWithoutMatchingPasswords() {
        //given
        UserDto user = new UserDto();
        user.setUsername(USERNAME);
        user.setPassword(PASSWORD_1);
        user.setMatchingPassword(PASSWORD_2);

        //when
        boolean result = validator.isValid(user, null);

        //then
        assertThat(result)
                .as("Should return false, for non matching passwords")
                .isFalse();
    }
}