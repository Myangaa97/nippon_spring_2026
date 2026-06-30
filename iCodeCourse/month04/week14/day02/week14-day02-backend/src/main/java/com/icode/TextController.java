package com.icode;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextController {
	
	@GetMapping(value = "/files/readme.txt", produces = MediaType.TEXT_PLAIN_VALUE)
	public String readMe() {
		return """
				Week 14 Readme
				Topic: First Rest Controller
				Today: Text, HTML, CSS, JSON
				""";
	}
}
