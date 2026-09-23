package com.icode.repository;

import com.icode.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	List<Comment> findByPostIdOrderByCreatedAtAsc(Long postId);
	
	List<Comment> findByUserIdOrderByCreatedAtDesc(Long userId);
}
