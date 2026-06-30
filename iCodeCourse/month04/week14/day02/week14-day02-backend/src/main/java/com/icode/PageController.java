package com.icode;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {
	
	@GetMapping(value = "/page-controller", produces = MediaType.TEXT_HTML_VALUE)
	public String page() {
		return """
				<!DOCTYPE html>
                <html>
	                <head>
	                    <title>Controller Page</title>
	                    <link rel="stylesheet" href="/controller-style.css">
	                </head>
	                <body>
	                    <h1>Hello from a REST Controller</h1>
	                    <p>This HTML came from a Java method.</p>
	                    <button onclick="showMessage()">Click</button>
	                    <script src="/controller-app.js"></script>
	                </body>
                </html>
				""";
	}
}
