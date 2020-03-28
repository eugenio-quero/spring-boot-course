package com.eugenio.courses.springbootcourse.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eugenio.courses.springbootcourse.model.User;

public interface UserRepository extends JpaRepository	<User, Long> {
	
	List<User> findByName(String name);
	Optional<User> findByEmail(String mail);
	Optional<User> findByNameAndEmail(String name, String mail);
}
