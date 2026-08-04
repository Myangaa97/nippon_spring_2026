package com.icode.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record StudentsRequest (
		@NotBlank(message = "First name is required")
		@Size(max = 255, message = "First name cannot exceed 255 characters")
		String firstName,
		
		@NotBlank(message = "Last name is required")
		@Size(max = 255, message = "Last name cannot exceed 255 characters")
		String lastName,
		
		@NotBlank(message = "Email is required")
		@Email(message = "Email Address is invalid")
		@Size(max = 255, message = "First name cannot exceed 255 characters")
		String email,
		
		@NotNull(message = "Department is required")
		Long departmentId
	
	){}
