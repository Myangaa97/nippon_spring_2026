package com.icode.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icode.dto.DepartmentsRequest;
import com.icode.dto.DepartmentsResponse;
import com.icode.exception.ConflictException;
import com.icode.exception.ResourceNotFoundException;
import com.icode.models.Departments;
import com.icode.repository.DepartmentRepository;
import com.icode.repository.StudentRepository;

@Service
@Transactional(readOnly = true)

public class DepartmentsService {
	private final DepartmentRepository departmentRepository;
	private final StudentRepository studentRepository;

	public DepartmentsService(DepartmentRepository departmentRepository, StudentRepository studentRepository) {
		this.departmentRepository = departmentRepository;
		this.studentRepository = studentRepository;
	}

	public List<DepartmentsResponse> findAll() {
		return departmentRepository.findAllByOrderByDepartmentNameAsc().stream().map(this::toResponse).toList();
	}

	public DepartmentsResponse findById(Long id) {
		Departments department = findDepartments(id);
		return toResponse(department);
	}
	
	
	@Transactional
	public DepartmentsResponse create(DepartmentsRequest request) {
		String name = request.departmentName().trim();
		if (departmentRepository.existsByDepartmentNameIgnoreCase(name)) {
			throw new ConflictException("A department with this name already exists");
		}
		Departments departments = new Departments(name);
		Departments saveDepartments = departmentRepository.save(departments);
		return toResponse(saveDepartments);
	}

	@Transactional
	public DepartmentsResponse update(Long id, DepartmentsRequest request) {
		Departments department = findDepartments(id);
		String name = request.departmentName().trim();
		boolean nameAlreadyUsed = departmentRepository.existsByDepartmentNameIgnoreCaseAndIdNot(name, id);
		if (nameAlreadyUsed) {
			throw new ConflictException("Another department already usse this name");
		}

		department.setDepartmentName(name);
		Departments updatDepartments = departmentRepository.save(department);
		return toResponse(updatDepartments);
	}

	@Transactional
	public void delete(Long id) {
		Departments department = findDepartments(id);
		boolean containsStudents = studentRepository.existsByDepartmentsId(id);
		if (containsStudents) {
			throw new ConflictException("Department cannot deletd, because it contains students");
		}
		departmentRepository.delete(department);
	}

	public Departments findDepartmentsEntity(Long id) {
		return findDepartments(id);
	}

	private Departments findDepartments(Long id) {
		return departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department with ID" + id));
	}

	public DepartmentsResponse toResponse(Departments department) {
		return new DepartmentsResponse(department.getId(), department.getDepartmentName());
	}
}
