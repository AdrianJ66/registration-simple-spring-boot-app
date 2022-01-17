package com.demo.application.registrationsimplewebapp.dto;

import lombok.Data;

@Data
public class UserDto {

    private String firstName;

    private String lastName;

    private String password;

    private String matchingPassword;

    private String email;

}
