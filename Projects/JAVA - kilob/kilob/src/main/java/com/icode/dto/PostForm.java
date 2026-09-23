package com.icode.dto;

import jakarta.validation.constraints.NotBlank;

public class PostForm {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private Long categoryId;

    // getters/setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }
}