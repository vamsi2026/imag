package com.imag.demo.validation;

import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * Validates a list of phone numbers against a predefined pattern.
 */
public class ListPhoneNumberValidator implements ConstraintValidator<ValidPhoneNumbers, List<String>> {
	private static final String PHONE_NUMBER_PATTERN = "\\+91\\d{10}";
	private Pattern pattern;

	// Initializes the validator with the specified annotation.
	@Override
	public void initialize(ValidPhoneNumbers constraintAnnotation) {
		pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
	}

	// Checks if the list of phone numbers is valid according to the predefined
	// pattern.
	@Override
	public boolean isValid(List<String> phoneNumbers, ConstraintValidatorContext context) {
		if (phoneNumbers == null || phoneNumbers.isEmpty()) {
			return true; // Allow null or empty list
		}

		for (String phoneNumber : phoneNumbers) {
			if (!pattern.matcher(phoneNumber).matches()) {
				return false; // Invalid phone number found
			}
		}

		return true; // All phone numbers are valid
	}
}
