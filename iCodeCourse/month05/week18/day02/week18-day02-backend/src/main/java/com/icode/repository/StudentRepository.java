package com.icode.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import com.icode.models.Students;


public interface StudentRepository extends JpaRepository<Students, Long> {
	@EntityGraph(attributePaths = "departments")
	
	List<Students> findAllByOrderByIdAsc();
	
	@Override
	@EntityGraph(attributePaths = "departments")
	Optional<Students> findById(Long id);
	
	boolean existsByEmailIgnoreCase(String email);
	
	boolean existsByEmailIgnoreCaseAndIdNot(String email, Long id);
	
	boolean existsByDepartmentsId(Long departmentsId);
	
}
