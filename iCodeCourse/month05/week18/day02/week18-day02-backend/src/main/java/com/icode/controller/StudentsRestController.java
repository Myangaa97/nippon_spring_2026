package com.icode.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.icode.dto.StudentsRequest;
import com.icode.dto.StudentsResponse;
import com.icode.service.StudentsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentsRestController {

    private final StudentsService studentsService;

    public StudentsRestController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    // Get all students
    @GetMapping
    public List<StudentsResponse> findAll() {
        return studentsService.findAll();
    }

    // Get student by id
    @GetMapping("/{id}")
    public StudentsResponse findById(@PathVariable Long id) {
        return studentsService.findById(id);
    }

    // Create student
    @PostMapping
    public ResponseEntity<StudentsResponse> create(
            @Valid @RequestBody StudentsRequest request) {

        StudentsResponse createdStudent = studentsService.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    // Update student
    @PutMapping("/{id}")
    public StudentsResponse update(
            @PathVariable Long id,
            @Valid @RequestBody StudentsRequest request) {

        return studentsService.update(id, request);
    }

    // Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        studentsService.delete(id);

        return ResponseEntity.noContent().build();
    }
}