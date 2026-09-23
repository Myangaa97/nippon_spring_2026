package com.icode.controller;

import com.icode.entity.Post;
import com.icode.entity.User;
import com.icode.service.CommentService;
import com.icode.service.PostService;
import com.icode.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {

    private final UserService userService;
    private final PostService postService;
    private final CommentService commentService;

    ProfileController(UserService userService, PostService postService, CommentService commentService) {
        this.userService = userService;
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("/profile")
    public String profile(@RequestParam(defaultValue = "0") int page,
                           Authentication authentication,
                           Model model) {

        User user = userService.findByUsername(authentication.getName());
        model.addAttribute("user", user);

        boolean isAdminOrAbove = authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN") || a.getAuthority().equals("ROLE_SUPER_ADMIN"));

        if (isAdminOrAbove) {
            Page<Post> myPosts = postService.getByUserId(user.getId(), PageRequest.of(page, 6));
            model.addAttribute("posts", myPosts);
        }

        model.addAttribute("comments", commentService.getCommentsByUser(user.getId()));

        return "user/profile";
    }
}