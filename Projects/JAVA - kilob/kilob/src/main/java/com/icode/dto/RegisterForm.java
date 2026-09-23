package com.icode.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterForm {

    @NotBlank(message = "Username хоосон байж болохгүй")
    @Size(min = 3, max = 50, message = "Username 3-50 тэмдэгт байна")
    private String username;

    @NotBlank(message = "Email хоосон байж болохгүй")
    @Email(message = "Email буруу форматтай байна")
    private String email;

    @NotBlank(message = "Password хоосон байж болохгүй")
    @Size(min = 6, message = "Password хамгийн багадаа 6 тэмдэгт байна")
    private String password;

    // getters/setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}