package com.eugenio.courses.springbootcourse.service.branch;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;

import com.eugenio.courses.springbootcourse.model.Branch;

public interface BranchService {

	Branch createOrUpdate(Branch usr);
	HttpStatus delete(Long id);
	
	List<Branch> findAll();
	List<Branch> findByName(String name);
	Optional<Branch> findById(Long id);
	List<Branch> findByOwner(Long ownerId);
}
