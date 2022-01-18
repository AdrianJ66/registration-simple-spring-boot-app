package com.demo.application.registrationsimplewebapp.validators;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface ValidPassword {

    String message() default "Sorry, password has to contain between 8-32 signs, 1 digit, 1 uppercase and 1 lowercase character";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
