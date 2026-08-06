package com.icode.service;

import java.util.List;

import com.icode.dto.StudentsRequest;
import com.icode.dto.StudentsResponse;

public interface StudentsService {

    List<StudentsResponse> findAll();

    StudentsResponse findById(Long id);

    StudentsResponse create(StudentsRequest request);

    StudentsResponse update(Long id, StudentsRequest request);

    void delete(Long id);

}