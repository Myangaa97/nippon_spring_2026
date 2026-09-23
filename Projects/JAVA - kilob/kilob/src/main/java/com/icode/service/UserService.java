package com.icode.service;

import com.icode.entity.RoleType;
import com.icode.entity.User;
import com.icode.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserService {
	
	private final UserRepository userRepository;
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	private final PasswordEncoder passwordEncoder;
	
	public User registerUser(String username, String email, String rawPassword) {
		if(userRepository.existsByUsername(username)) {
			throw new IllegalArgumentException("Username already taken");
		}
		
		if (userRepository.existsByEmail(email)) {
			throw new IllegalArgumentException("Email already registered");
		}
		
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(passwordEncoder.encode(rawPassword));
		user.setRole(RoleType.ROLE_USER);
		
		return userRepository.save(user);
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new IllegalArgumentException("User not found"));
	}
	
	public User changeRole(Long userId, RoleType newRole) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("User not found"));
		user.setRole(newRole);
		return userRepository.save(user);
	}

	public void deleteUser(long id) {
		if(!userRepository.existsById(id)) {
			throw new IllegalArgumentException("User not found");
		}
	
		userRepository.deleteById(id);
	}
}
