package com.imag.demo.service;

import com.imag.demo.entity.TaxResponse;

/**
 * Specifies a method to calculate tax deductions for an employee.
 */
public interface TaxCalculationService {
	// Calculates Tax deductions.
	TaxResponse calculateTaxDeduction(Long employeeId);
}
