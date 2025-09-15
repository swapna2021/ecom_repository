package com.renderdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class RenderDemoAppApplication {
	
	
	@GetMapping("/hello")
	public String sayHello() {
		
		return "helloooo";
	}

	public static void main(String[] args) {
		SpringApplication.run(RenderDemoAppApplication.class, args);
	}

}
