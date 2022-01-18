package com.demo.application.registrationsimplewebapp.exceptions.handler;

import java.util.Date;

import lombok.Getter;

@Getter
public class ExceptionResponse {

    private final Date date;

    private final String message;

    private final String details;

    public ExceptionResponse(Date date, String message, String details) {
        this.date = date;
        this.message = message;
        this.details = details;
    }

}
