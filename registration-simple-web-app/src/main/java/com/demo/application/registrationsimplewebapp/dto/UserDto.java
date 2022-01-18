package com.demo.application.registrationsimplewebapp.dto;

import com.demo.application.registrationsimplewebapp.validators.PasswordMatches;
import com.demo.application.registrationsimplewebapp.validators.UniqueUsername;
import com.demo.application.registrationsimplewebapp.validators.ValidPassword;
import com.demo.application.registrationsimplewebapp.validators.ValidUsername;

import lombok.Data;

@Data
@PasswordMatches
public class UserDto {

    @ValidUsername
    @UniqueUsername
    private String username;

    @ValidPassword
    private String password;

    private String matchingPassword;
}
