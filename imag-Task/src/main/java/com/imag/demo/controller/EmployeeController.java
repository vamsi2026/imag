package com.imag.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imag.demo.entity.Employee;
import com.imag.demo.entity.TaxResponse;
import com.imag.demo.service.EmployeeService;
import com.imag.demo.service.TaxCalculationService;

import jakarta.validation.Valid;

/**
 * REST controller for managing employee data and tax calculations.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	private final TaxCalculationService taxCalculationService;

	/**
	 * Initializes the EmployeeController with EmployeeService and
	 * TaxCalculationService dependencies.
	 * 
	 * @param employeeService
	 * @param taxCalculationService
	 */
	public EmployeeController(EmployeeService employeeService, TaxCalculationService taxCalculationService) {
		super();
		this.employeeService = employeeService;
		this.taxCalculationService = taxCalculationService;
	}

	// Creates a new employee record, handling validation errors.
	@PostMapping
	public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		Employee savedEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	// Retrieves an employee by ID and calculates tax deductions for the employee.
	@GetMapping("/{employeeId}")
	public ResponseEntity<TaxResponse> getEmployeeById(@PathVariable Long employeeId) {
		Employee employee = employeeService.getEmployeeById(employeeId);
		if (employee == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		TaxResponse taxResponse = taxCalculationService.calculateTaxDeduction(employeeId);
		return new ResponseEntity<>(taxResponse, HttpStatus.OK);
	}
}
