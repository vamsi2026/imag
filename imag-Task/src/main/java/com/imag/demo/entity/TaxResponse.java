package com.imag.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a response object for tax calculations
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaxResponse {
	private Long employeeId;
	private String firstName;
	private String lastName;
	private double yearlySalary;
	private double taxAmount;
	private double cessAmount;
}
