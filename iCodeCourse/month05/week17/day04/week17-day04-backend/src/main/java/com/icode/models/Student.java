package com.icode.models;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false, unique = true, length = 100)
	private String email;
	
	@Column(name = "enrolled_at")
	private LocalDate enrolAt = LocalDate.now();
	
	public Student() {
		
	}
	
	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getEnrolAt() {
		return enrolAt;
	}

	public void setEnrolAt(LocalDate enrolAt) {
		this.enrolAt = enrolAt;
	}
	
	
}
