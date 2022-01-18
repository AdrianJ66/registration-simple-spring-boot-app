package com.demo.application.registrationsimplewebapp.validators;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.application.registrationsimplewebapp.services.UserService;

@ExtendWith(MockitoExtension.class)
class UsernameUniquenessValidatorTest {

    private static final String USERNAME = "TestUsername";

    @InjectMocks
    private UsernameUniquenessValidator validator;

    @Mock
    private UserService service;

    @Test
    void testValidationWithoutUniqueUsername() {
        //given
        when(service.userWithGivenUsernameExists(USERNAME)).thenReturn(true);

        //when
        boolean result = validator.isValid(USERNAME, null);

        //then
        assertThat(result)
                .as("Should return false, for existing username")
                .isFalse();
    }

    @Test
    void testValidationWithUniqueUsername() {
        //given
        when(service.userWithGivenUsernameExists(USERNAME)).thenReturn(false);

        //when
        boolean result = validator.isValid(USERNAME, null);

        //then
        assertThat(result)
                .as("Should return true, for unique username")
                .isTrue();
    }
}