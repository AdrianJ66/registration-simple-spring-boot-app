package com.demo.application.registrationsimplewebapp.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.application.registrationsimplewebapp.converters.UserDtoToUserConverter;
import com.demo.application.registrationsimplewebapp.converters.UserToUserDtoConverter;
import com.demo.application.registrationsimplewebapp.model.User;
import com.demo.application.registrationsimplewebapp.repositories.UserRepository;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private static final String USERNAME = "TestUsername";

    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserToUserDtoConverter userToUserDtoConverter;

    @Mock
    private UserDtoToUserConverter userDtoToUserConverter;

    @Test
    public void testRegisterNewUser() {

    }

    @Test
    public void testIfChecksUsernameUniqueness() {
        //given
        when(userRepository.findByUsername(USERNAME)).thenReturn(new User());

        //when
        boolean result = service.userWithGivenUsernameExists(USERNAME);

        //then
        assertThat(result)
                .as("If given username is already used, true should be returned")
                .isTrue();
    }
}