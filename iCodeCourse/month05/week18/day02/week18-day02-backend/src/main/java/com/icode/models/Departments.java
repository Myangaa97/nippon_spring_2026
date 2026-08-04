package com.icode.models;

import jakarta.persistence.*;

@Entity
@Table(name = "departments", uniqueConstraints = {
		@UniqueConstraint(columnNames = "department_name", name = "uk_departments_name") })

public class Departments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String departmentName;

	protected Departments() {

	}

	public Departments(String departmentName) {
		this.departmentName = departmentName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
