package com.udemy.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
