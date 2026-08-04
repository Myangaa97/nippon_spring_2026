package com.icode.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DepartmentsRequest(
		@NotBlank(message = "Department name is required") @Size(max = 100, message = "Departmnet name connot exceed 100 characters") String departmentName) {

}
