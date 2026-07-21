package com.icode.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.icode.model.Clubs;
import com.icode.repository.ClubRepository;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/clubs")

public class ClubController {
	private final ClubRepository clubRepository;
	
	public ClubController(ClubRepository clubRepository) {
		this.clubRepository = clubRepository;
	}
	
	// All Club pick
	@GetMapping
	public List<Clubs>getAllClubs() {
		return clubRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Clubs> getClubsId(@PathVariable Long id) {
		Optional<Clubs> club = clubRepository.findById(id);
		
		return club.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
}
