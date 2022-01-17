package com.demo.application.registrationsimplewebapp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.demo.application.registrationsimplewebapp.validators.ValidEmail;

import lombok.Data;

@Data
public class UserDto {

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String password;

    private String matchingPassword;

    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;

}
