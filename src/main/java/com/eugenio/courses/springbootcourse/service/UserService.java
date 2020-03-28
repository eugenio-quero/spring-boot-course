package com.eugenio.courses.springbootcourse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;

import com.eugenio.courses.springbootcourse.model.User;

public interface UserService {

	User createOrUpdate(User usr);
	HttpStatus delete(Long id);
	
	List<User> findAll();
	List<User> findByName(String name);
	Optional<User> findById(Long id);
	Optional<User> findByEmail(String mail);
}
