package com.udemy.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
