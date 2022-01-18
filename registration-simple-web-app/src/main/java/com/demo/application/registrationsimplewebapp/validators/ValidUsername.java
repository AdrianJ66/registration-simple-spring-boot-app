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
@Constraint(validatedBy = UsernameValidator.class)
@Documented
public @interface ValidUsername {

    String message() default "Sorry, user name has to contain at least 5 alphanumeric signs and be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
