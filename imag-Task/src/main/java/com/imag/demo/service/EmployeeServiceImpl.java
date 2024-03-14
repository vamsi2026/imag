package com.imag.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imag.demo.entity.Employee;
import com.imag.demo.repository.EmployeeRepository;

/**
 * Implements the EmployeeService interface to provide methods for managing
 * Employee entities.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	/**
	 * 
	 * This constructor initializes the employeeRepository field of the
	 * EmployeeServiceImpl class with the provided employeeRepository instance.
	 * 
	 * @param employeeRepository
	 */
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	// Saves a new Employee entity or updates an existing one using the
	// EmployeeRepository.
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	// Retrieves a list of all Employee entities using the EmployeeRepository.
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	// Retrieves an Employee entity by its ID using the EmployeeRepository.
	public Employee getEmployeeById(Long employeeId) {
		return employeeRepository.findById(employeeId).orElse(null);
	}

	// Deletes an Employee entity by its ID using the EmployeeRepository.
	public void deleteEmployeeById(Long employeeId) {
		employeeRepository.deleteById(employeeId);
	}
}
