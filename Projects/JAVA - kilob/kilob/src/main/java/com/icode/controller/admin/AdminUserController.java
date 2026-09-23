package com.icode.controller.admin;

import com.icode.entity.RoleType;
import com.icode.repository.UserRepository;
import com.icode.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
@PreAuthorize("hasRole('SUPER_ADMIN')")
public class AdminUserController {

    private final UserRepository userRepository;

    private final UserService userService;

    AdminUserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin/users";
    }

    @PostMapping("/{id}/role")
    public String changeRole(@PathVariable Long id, @RequestParam RoleType role) {
        userService.changeRole(id, role);
        return "redirect:/admin/users";
    }
    
    @PostMapping("/{id}/delete")
    public String delte(@PathVariable long id) {
    	userService.deleteUser(id);
    	return "redirect:/admin/users";
    }
}