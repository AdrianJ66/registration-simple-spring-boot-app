package com.demo.application.registrationsimplewebapp.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.demo.application.registrationsimplewebapp.dto.UserDto;
import com.demo.application.registrationsimplewebapp.model.User;

class UserToUserDtoConverterTest {

    private static final String USERNAME = "TestUsername";

    private static final String PASSWORD = "TestPass1";

    UserToUserDtoConverter converter;

    @BeforeEach
    void setUp() {
        converter = new UserToUserDtoConverter();
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new User()));
    }

    @Test
    public void testConversion() {
        //given
        User user = new User();
        user.setUsername(USERNAME);
        user.setPassword(PASSWORD);

        //when
        UserDto result = converter.convert(user);

        //then
        assertThat(result.getUsername())
                .as("Should copy username from User object")
                .isEqualTo(USERNAME);
        assertThat(result.getPassword())
                .as("Should copy password from User object")
                .isEqualTo(PASSWORD);
        assertThat(result.getMatchingPassword())
                .as("Should copy matching password from User object")
                .isEqualTo(PASSWORD);
    }
}