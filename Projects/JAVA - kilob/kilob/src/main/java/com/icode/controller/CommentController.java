package com.icode.controller;

import com.icode.entity.Comment;
import com.icode.entity.Post;
import com.icode.entity.User;
import com.icode.service.CommentService;
import com.icode.service.PostService;
import com.icode.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

    private final CommentService commentService;

    private final PostService postService;

    private final UserService userService;

    CommentController(CommentService commentService, PostService postService, UserService userService) {
        this.commentService = commentService;
        this.postService = postService;
        this.userService = userService;
    }

    // ---------------- CREATE COMMENT ----------------
    @PostMapping("/posts/{postId}/comments")
    public String addComment(@PathVariable Long postId,
                              @RequestParam String content,
                              Authentication authentication) {

        if (authentication == null || !authentication.isAuthenticated()
                || authentication.getName().equals("anonymousUser")) {
            return "redirect:/login";
        }

        Post post = postService.getPostById(postId);
        User user = userService.findByUsername(authentication.getName());
        commentService.addComment(post, user, content);

        return "redirect:/posts/" + postId;
    }

    // ---------------- DELETE COMMENT ----------------
    @PostMapping("/comments/{id}/delete")
    public String deleteComment(@PathVariable Long id,
                                 @RequestParam Long postId,
                                 Authentication authentication,
                                 org.springframework.ui.Model model) {

        Comment comment = commentService.getCommentsForPost(postId).stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));

        String currentUsername = authentication.getName();
        boolean isOwner = comment.getUser().getUsername().equals(currentUsername);
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN") || a.getAuthority().equals("ROLE_SUPER_ADMIN"));

        if (!isOwner && !isAdmin) {
            throw new org.springframework.security.access.AccessDeniedException("Not allowed");
        }

        commentService.deleteComment(id);

        return "redirect:/posts/" + postId;
    }
}