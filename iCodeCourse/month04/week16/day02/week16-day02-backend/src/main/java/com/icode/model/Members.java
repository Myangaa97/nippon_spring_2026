package com.icode.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Members {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false, length = 200)
	private String email;
	
	@Column(name = "full_name", nullable = false, length = 100)
	private String fullName;
	
	@Column(name = "subscription_fee", precision = 10, scale = 2)
	private BigDecimal subscriptionFee;
	
	
	@Column(name = "joined_at", updatable = false)
	private ZonedDateTime joinedAt = ZonedDateTime.now();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "club_id")
	@JsonBackReference
	private Clubs clubs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public BigDecimal getSubscriptionFee() {
		return subscriptionFee;
	}

	public void setSubscriptionFee(BigDecimal subscriptionFee) {
		this.subscriptionFee = subscriptionFee;
	}

	public ZonedDateTime getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(ZonedDateTime joinedAt) {
		this.joinedAt = joinedAt;
	}

	public Clubs getClubs() {
		return clubs;
	}

	public void setClubs(Clubs clubs) {
		this.clubs = clubs;
	}
}
