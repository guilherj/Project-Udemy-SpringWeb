package com.udemy.course.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.course.entities.User;

@RestController
@RequestMapping("users")
public class UserController {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User(1L,"Guilherme", "guilherme@gmail.com", "8888", "123");
		return ResponseEntity.ok().body(user);
		
	}

}
