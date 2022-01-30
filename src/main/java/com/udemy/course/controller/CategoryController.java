package com.udemy.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.course.entities.Category;
import com.udemy.course.services.CategoryService;

@RestController
@RequestMapping("categories")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		
		List<Category> list = service.findAll();		
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
