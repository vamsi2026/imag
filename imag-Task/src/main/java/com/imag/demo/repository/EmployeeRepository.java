package com.imag.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imag.demo.entity.Employee;

/**
 * Extends JpaRepository to provide CRUD operations for Employee entities.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
