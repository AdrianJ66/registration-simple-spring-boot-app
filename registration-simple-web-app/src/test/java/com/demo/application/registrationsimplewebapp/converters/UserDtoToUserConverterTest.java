package com.demo.application.registrationsimplewebapp.converters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.demo.application.registrationsimplewebapp.dto.UserDto;
import com.demo.application.registrationsimplewebapp.model.User;

class UserDtoToUserConverterTest {

    private static final String USERNAME = "TestUsername";

    private static final String PASSWORD = "TestPass1";

    UserDtoToUserConverter converter;

    @BeforeEach
    void setUp() {
        converter = new UserDtoToUserConverter();
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new UserDto()));
    }

    @Test
    public void testConversion() {
        //given
        UserDto userDto = new UserDto();
        userDto.setUsername(USERNAME);
        userDto.setPassword(PASSWORD);
        userDto.setMatchingPassword(PASSWORD);

        //when
        User result = converter.convert(userDto);

        //then
        assertThat(result.getUsername())
                .as("Should copy username from DTO object")
                .isEqualTo(USERNAME);
        assertThat(result.getPassword())
                .as("Should copy password from DTO object")
                .isEqualTo(PASSWORD);
    }
}