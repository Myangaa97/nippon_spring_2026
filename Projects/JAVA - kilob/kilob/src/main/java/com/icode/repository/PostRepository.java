package com.icode.repository;

import com.icode.entity.Post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PostRepository extends JpaRepository<Post, Long>{
	Page<Post> findByTitleContainingIgnoreCase(String title, Pageable pageable);
	
	Page<Post> findByCategoryId(Long categoryId, Pageable pageable);
	
	Page<Post> findByTitleContainingIgnoreCaseAndCategoryId(String title, Long categoryId, Pageable pageable);
	
	Page<Post> findByUserId(Long userId, Pageable pageable);
	
	@Modifying
	@Transactional
	@Query("UPDATE Post p SET p.likeCount = p.likeCount + 1 WHERE p.id = :id")
	void incrementLikeCount(@Param("id") Long id);
}
