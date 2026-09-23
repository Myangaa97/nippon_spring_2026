package com.icode.controller;

import com.icode.entity.Category;
import com.icode.entity.Post;
import com.icode.service.CategoryService;
import com.icode.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {

    private final CategoryService categoryService;
    private final PostService postService;

    CategoryController(CategoryService categoryService, PostService postService) {
        this.categoryService = categoryService;
        this.postService = postService;
    }

    @GetMapping("/category/{id}")
    public String postsByCategory(@PathVariable Long id,
                                   @RequestParam(defaultValue = "0") int page,
                                   Model model) {

        Category category = categoryService.getCategoryById(id);
        Page<Post> posts = postService.getByCategory(id, PageRequest.of(page, 9));

        model.addAttribute("category", category);
        model.addAttribute("posts", posts);
        model.addAttribute("categories", categoryService.getAllCategories());

        return "post/index"; // post/index.html-ийг дахин ашиглана
    }
}