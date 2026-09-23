package com.icode.controller;

import com.icode.entity.Post;
import com.icode.service.CategoryService;
import com.icode.service.CommentService;
import com.icode.service.PostService;
import com.icode.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    private final CategoryService categoryService;

    private final CommentService commentService;

    PostController(PostService postService, CategoryService categoryService, CommentService commentService, UserService userService) {
        this.postService = postService;
        this.categoryService = categoryService;
        this.commentService = commentService;
    }

    // ---------------- LIST + SEARCH + CATEGORY + PAGINATION ----------------
    @GetMapping
    public String list(@RequestParam(defaultValue = "0") int page,
                        @RequestParam(required = false) String keyword,
                        @RequestParam(required = false) Long categoryId,
                        Model model) {

        Pageable pageable = PageRequest.of(page, 9); // хуудас бүрт 9 post
        Page<Post> posts;

        if (keyword != null && !keyword.isBlank()) {
            posts = postService.searchByTitle(keyword, pageable);
        } else if (categoryId != null) {
            posts = postService.getByCategory(categoryId, pageable);
        } else {
            posts = postService.getAllPosts(pageable);
        }

        model.addAttribute("posts", posts);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("keyword", keyword);
        model.addAttribute("categoryId", categoryId);

        return "post/index";
    }

    // ---------------- DETAIL ----------------
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        model.addAttribute("comments", commentService.getCommentsForPost(id));
        return "post/detail";
    }
    
    @PostMapping("/{id}/like")
    public String like(@PathVariable Long id) {
        postService.likePost(id);
        return "redirect:/posts/" + id;
    }
}