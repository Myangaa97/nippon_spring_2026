package com.icode.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.icode.dto.DepartmentsRequest;
import com.icode.dto.DepartmentsResponse;
import com.icode.service.DepartmentsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
//	private final DepartmentsRequest departmentsRequest;
	private final DepartmentsService departmentsService;

	public DepartmentController(DepartmentsService departmentsService, DepartmentsRequest departmentsRequest) {
		this.departmentsService = departmentsService;
//		this.departmentsRequest = departmentsRequest;
	}

	@GetMapping
	public List<DepartmentsResponse> findAll() {
		return departmentsService.findAll();
	}

	@PostMapping
	public ResponseEntity<DepartmentsResponse> 
		create(@Valid @RequestBody DepartmentsRequest request) {
		DepartmentsResponse creaDepartments = departmentsService.create(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(creaDepartments);

	}
	
	@PutMapping("/{id}") 
	public DepartmentsResponse update(@PathVariable Long id, @Valid @RequestBody DepartmentsRequest request) {
		return departmentsService.update(id, request);
	}
	
	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		departmentsService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	// find by id
	@GetMapping("/{id}")
	public DepartmentsResponse findById(@PathVariable Long id) {
		return departmentsService.findById(id);
	}

}
