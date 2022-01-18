package com.demo.application.registrationsimplewebapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.demo.application.registrationsimplewebapp.validators.ValidEmail;

import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String firstName;

    private String lastName;

    private String password;

    private String matchingPassword;

    private String email;
}
