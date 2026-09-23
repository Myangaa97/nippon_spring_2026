package com.icode.controller.admin;

import com.icode.dto.PostForm;
import com.icode.entity.Post;
import com.icode.entity.User;
import com.icode.service.CategoryService;
import com.icode.service.PostService;
import com.icode.service.UserService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/posts")
@PreAuthorize("hasAnyRole('ADMIN', 'ROLE_SUPER_ADMIN')")
public class AdminPostController {

    private final PostService postService;

    private final CategoryService categoryService;

    private final UserService userService;

    AdminPostController(PostService postService, CategoryService categoryService, UserService userService) {
        this.postService = postService;
        this.categoryService = categoryService;
        this.userService = userService;
    }
    
    @GetMapping
    public String list(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<Post> posts = postService.getAllPosts(PageRequest.of(page, 10));
        model.addAttribute("posts", posts);
        return "admin/post-list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("postForm", new PostForm());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "admin/post-form";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute PostForm form, Authentication authentication) {
        User author = userService.findByUsername(authentication.getName());
        Post post = postService.createPost(form.getTitle(), form.getContent(), form.getCategoryId(), author);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);

        PostForm form = new PostForm();
        form.setTitle(post.getTitle());
        form.setContent(post.getContent());
        if (post.getCategory() != null) {
            form.setCategoryId(post.getCategory().getId());
        }

        model.addAttribute("postForm", form);
        model.addAttribute("postId", id);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "admin/post-form";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable Long id, @ModelAttribute PostForm form) {
        postService.updatePost(id, form.getTitle(), form.getContent(), form.getCategoryId());
        return "redirect:/posts/" + id;
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }
}