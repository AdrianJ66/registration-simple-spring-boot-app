package com.demo.application.registrationsimplewebapp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.demo.application.registrationsimplewebapp.dto.UserDto;
import com.demo.application.registrationsimplewebapp.model.User;

import lombok.Synchronized;

@Component
public class UserDtoToUserConverter implements Converter<UserDto, User> {

    @Override
    @Synchronized
    @Nullable
    public User convert(UserDto source) {
        if (source == null) {
            return null;
        }

        User user = new User();
        user.setUsername(source.getUsername());
        user.setPassword(source.getPassword());

        return user;
    }
}
