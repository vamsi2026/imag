package com.imag.demo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ListPhoneNumberValidator.class)
public @interface ValidPhoneNumbers {
	String message() default "Phone number must be in the format +91XXXXXXXXXX";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
