package com.demo.application.registrationsimplewebapp.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.application.registrationsimplewebapp.exceptions.UserAlreadyExistsException;

@ControllerAdvice
public class UserAlreadyExistsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity handleUserAlreadyExistsException(UserAlreadyExistsException exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse(new Date(), exception.getMessage(),
                webRequest.getDescription(true));

        return new ResponseEntity(response, HttpStatus.CONFLICT);
    }
}
