package com.imag.demo.entity;

import java.util.List;

import com.imag.demo.validation.ValidPhoneNumbers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an employee entity
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "imagEmployee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;

	@NotBlank(message = "First Name is required")
	private String firstName;

	@NotBlank(message = "Last Name is required")
	private String lastName;

	@Email(message = "Invalid Email format")
	@NotBlank(message = "Email is required")
	private String email;

	@Column(unique = true)
	@ValidPhoneNumbers
	List<String> phoneNumber;

	@NotBlank(message = "Date of Joining is required")
	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date of Joining must be in the format yyyy-MM-dd")
	private String  doj;

	@NotNull(message = "Salary is required")
	private Double salary;
}
