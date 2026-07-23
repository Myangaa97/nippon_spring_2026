package com.kilob.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.kilob.entity.User;
import com.kilob.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@DeleteMapping("/{id}") 
	public String deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return "Deleted";
	}
}
