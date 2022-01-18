package com.demo.application.registrationsimplewebapp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.demo.application.registrationsimplewebapp.validators.PasswordMatches;
import com.demo.application.registrationsimplewebapp.validators.ValidEmail;

import lombok.Data;

@Data
@PasswordMatches
public class UserDto {

    @NotNull
    @NotEmpty(message = "Sorry, this field cannot be left blank")
    private String firstName;

    @NotNull
    @NotEmpty(message = "Sorry, this field cannot be left blank")
    private String lastName;

    @NotNull
    @NotEmpty(message = "Sorry, this field cannot be left blank")
    private String password;

    private String matchingPassword;

    @ValidEmail
    @NotNull
    @NotEmpty(message = "Sorry, this field cannot be left blank")
    private String email;

}
