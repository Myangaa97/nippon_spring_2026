package com.icode.dto;

public record StudentsRespose(
		long id,
		String firstname,
		String lastName,
		String email,
		Long departmentId,
		String departmentName
		)

{
	
}
