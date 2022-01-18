package com.demo.application.registrationsimplewebapp.services;

import com.demo.application.registrationsimplewebapp.dto.UserDto;

public interface UserService {
    UserDto registerNewUser(UserDto user);
}
