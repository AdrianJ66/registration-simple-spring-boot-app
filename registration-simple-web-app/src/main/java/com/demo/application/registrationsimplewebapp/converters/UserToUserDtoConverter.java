package com.demo.application.registrationsimplewebapp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.demo.application.registrationsimplewebapp.dto.UserDto;
import com.demo.application.registrationsimplewebapp.model.User;

import lombok.Synchronized;

@Component
public class UserToUserDtoConverter implements Converter<User, UserDto> {

    @Override
    @Synchronized
    @Nullable
    public UserDto convert(User source) {
        if (source == null) {
            return null;
        }

        UserDto user = new UserDto();
        user.setUsername(source.getUsername());
        user.setPassword(source.getPassword());
        user.setMatchingPassword(source.getPassword());

        return user;
    }
}
