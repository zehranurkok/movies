package com.zehranurkok.movies;

// StringApplication class contains a particular method called Run
import org.springframework.boot.SpringApplication;
// Let the compiler know about what this class does
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
////  Let the framework know that this class is actually REST API controller
//@RestController
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

//	// This give mapping an notation to each, lets the framework know that apiRoot is a good endpoint
//	@GetMapping("/root")
//	public String apiRoot() {
//		return "Hello World";
//	}

 }
