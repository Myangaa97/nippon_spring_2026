package com.icode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	public record HelloResponse(String message, int week) {}
	
	@GetMapping("/api/hello")
	public String hello() {
		return "Hello World! ";
	}
	
// JSON - Javascript Oblect Notation
	
	@GetMapping("/api/status")
	public HelloResponse status() {
		return new HelloResponse("Rest controller is working :)", 14);
	}
}
