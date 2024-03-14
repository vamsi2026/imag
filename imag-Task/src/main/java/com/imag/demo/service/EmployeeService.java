package com.imag.demo.service;

import java.util.List;

import com.imag.demo.entity.Employee;

/**
 * Specifies the methods to be implemented for managing Employee entities.
 */
public interface EmployeeService {
	
	//Saves a new Employee entity or updates an existing one.
	Employee saveEmployee(Employee employee);

	//Retrieves a list of all Employee entities.
	List<Employee> getAllEmployees();

	//Retrieves an Employee entity by its ID.
	Employee getEmployeeById(Long id);

	//Deletes an Employee entity by its ID.
	void deleteEmployeeById(Long id);
}
