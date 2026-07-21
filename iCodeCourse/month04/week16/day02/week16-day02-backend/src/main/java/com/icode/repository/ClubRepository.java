package com.icode.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icode.model.Clubs;

@Repository
public interface ClubRepository extends JpaRepository<Clubs, Long>{
	// 1. Spring Data JPA -iin SQL bichihgvigeer
	// Select * FROM clubs WHERE name = ?
	Optional<Clubs> findByName(String name);
	
	//2. only isActive club-s tvvh
	// Select * FROM clubs WHERE i = ?
	List<Clubs> findByIsActiveTrue();
	
	List<Clubs> findByCategory(String category);
}
