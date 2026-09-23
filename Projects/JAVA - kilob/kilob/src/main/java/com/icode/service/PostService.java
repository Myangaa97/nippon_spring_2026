package com.icode.service;

import com.icode.entity.Category;
import com.icode.entity.Post;
import com.icode.entity.User;
import com.icode.repository.CategoryRepository;
import com.icode.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

@Service
public class PostService {
	
	private final PostRepository postRepository;
	
	private final CategoryRepository categoryRepository;

    PostService(PostRepository postRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
    }
	
	public Page<Post> getAllPosts(Pageable pageable) {
		return postRepository.findAll(pageable);
	}
	
	public Page<Post> searchByTitle(String keyword, Pageable pageable) {
		return postRepository.findByTitleContainingIgnoreCase(keyword, pageable);
	}
	
	public Page<Post> getByCategory(Long categoryId, Pageable pageable) {
		return postRepository.findByCategoryId(categoryId, pageable);
	}
	
	public Page<Post> getByUserId(Long userId, Pageable pageable) {
	    return postRepository.findByUserId(userId, pageable);
	}
	
	public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));
    }
	
	public Post createPost(String title, String content, Long categoryId, User author) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(Jsoup.clean(content, Safelist.relaxed()));
        post.setUser(author);

        if (categoryId != null) {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new IllegalArgumentException("Category not found"));
            post.setCategory(category);
        }

        return postRepository.save(post);
    }

    public Post updatePost(Long id, String title, String content, Long categoryId) {
        Post post = getPostById(id);
        post.setTitle(title);
        post.setContent(content);

        if (categoryId != null) {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new IllegalArgumentException("Category not found"));
            post.setCategory(category);
        } else {
            post.setCategory(null);
        }

        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
    
    @Transactional
    public void likePost(Long id) {
        postRepository.incrementLikeCount(id);
    }
}
