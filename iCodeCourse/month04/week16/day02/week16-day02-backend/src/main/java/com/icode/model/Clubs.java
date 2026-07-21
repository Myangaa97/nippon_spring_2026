package com.icode.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "clubs")
public class Clubs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false, length = 150)
	private String name;
	
	@Column(name = "founded_date")
	private LocalDate foundedDate;
	
	@Column(name = "is_active")
	private Boolean isActive = true;
	
	@OneToMany(mappedBy = "clubs", cascade = CascadeType.ALL)
	private List<Members> members = new ArrayList<>();
	
	@Column
	private String category;

	public List<Members> getMembers() {
		return members;
	}

	public void setMembers(List<Members> members) {
		this.members = members;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getFoundedDate() {
		return foundedDate;
	}

	public void setFoundedDate(LocalDate foundedDate) {
		this.foundedDate = foundedDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
