package com.imag.demo.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import com.imag.demo.constants.StringConstants;
import com.imag.demo.entity.Employee;
import com.imag.demo.entity.TaxResponse;
import com.imag.demo.exception.EmployeeException;
import com.imag.demo.repository.EmployeeRepository;

/**
 * Implements the TaxCalculationService interface to provide a method for
 * calculating tax deductions for an employee.
 */
@Service
public class TaxCalculationServiceImpl implements TaxCalculationService {

	private final EmployeeRepository employeeRepository;

	/**
	 * 
	 * This constructor initializes the employeeRepository field of the
	 * TaxCalculationServiceImpl class with the provided employeeRepository
	 * instance.
	 * 
	 * @param employeeRepository
	 */
	public TaxCalculationServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	// Calculates tax deductions for the employee with the specified ID using the
	// EmployeeRepository.
	@Override
	public TaxResponse calculateTaxDeduction(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElse(null);
		if (employee == null) {
			throw new EmployeeException(StringConstants.EMPLOYEENOTFOUND);
		}

		LocalDate currentDate = LocalDate.now();
		LocalDate joiningDate = LocalDate.parse(employee.getDoj());

		int monthsWorked = (int) (Period.between(joiningDate, currentDate).toTotalMonths() + 1);
		if (monthsWorked <= 0) {
			throw new EmployeeException(StringConstants.EMPLOYEENOTJOINED);
		}

		double yearlySalary = employee.getSalary() * monthsWorked;

		double taxAmount = calculateTax(yearlySalary);
		double cessAmount = yearlySalary > 2500000 ? (yearlySalary - 2500000) * 0.02 : 0;

		return new TaxResponse(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), yearlySalary,
				taxAmount, cessAmount);
	}

	// Calculates the tax amount based on the total salary.
	public double calculateTax(double totalSalary) {
		double tax = 0;
		if (totalSalary <= 250000) {
			tax = 0;
		} else if (totalSalary <= 500000) {
			tax = (totalSalary - 250000) * 0.05;
		} else if (totalSalary <= 1000000) {
			tax = 12500 + (totalSalary - 500000) * 0.1;
		} else {
			tax = 62500 + (totalSalary - 1000000) * 0.2;
		}
		return tax;
	}
}
