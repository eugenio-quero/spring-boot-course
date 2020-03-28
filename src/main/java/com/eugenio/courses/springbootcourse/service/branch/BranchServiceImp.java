package com.eugenio.courses.springbootcourse.service.branch;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.eugenio.courses.springbootcourse.model.Branch;
import com.eugenio.courses.springbootcourse.repository.BranchRepository;

@Service
public class BranchServiceImp implements BranchService{

	BranchRepository repo;
	
	
	public BranchServiceImp(BranchRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Branch> findAll() {
		return repo.findAll();
	}

	@Override
	public List<Branch> findByName(String name) {
		return repo.findByName(name);
	}

	@Override
	public Optional<Branch> findById(Long id) {
		return repo.findById(id);
	}

	@Override
	public List<Branch> findByOwner(Long ownerId) {
		return repo.findByOwner(ownerId);
	}

	@Override
	public Branch createOrUpdate(Branch usr) {
		return repo.save(usr);
	}

	@Override
	public HttpStatus delete(Long id) {
		try {
			repo.deleteById(id);
			return HttpStatus.OK;
		}catch(EmptyResultDataAccessException ex) {
			return HttpStatus.NOT_FOUND;
		}
	}
}
