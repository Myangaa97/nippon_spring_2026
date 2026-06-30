package com.icode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssetController {
	
	@GetMapping(value = "/controller-style.css", produces = "text/css")
	public String css() {
		return """
				body {
                    font-family: Arial, sans-serif;
                    margin: 40px;
                    background: #f5f7fb;
                }

                h1 {
                    color: #1f4e79;
                }

                button {
                    padding: 10px 16px;
                    border: 0;
                    background: #1f4e79;
                    color: white;
                }
				""";
	}
	
	@GetMapping(value = "/controller-app.js", produces = "application/javascript")
	public String js() {
		return """
				function showMessage() {
                    alert("JavaScript came from a Spring Boot controller");
                }
				""";
	}
}
