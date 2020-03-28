package com.eugenio.courses.springbootcourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eugenio.courses.springbootcourse.model.Branch;

public interface BranchRepository extends JpaRepository	<Branch, Long> {
	
	List<Branch> findByName(String name);
	List<Branch> findByOwner(Long ownerId);
}
