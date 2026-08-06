package com.icode.dto;

public record StudentsResponse(
		long id,
		String firstname,
		String lastName,
		String email,
		Long departmentId,
		String departmentName
		)

{
	
}
