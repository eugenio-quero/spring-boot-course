package com.eugenio.courses.springbootcourse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.eugenio.courses.springbootcourse.model.User;
import com.eugenio.courses.springbootcourse.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

	UserRepository repo;
	
	
	public UserServiceImp(UserRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<User> findAll() {
		return repo.findAll();
	}

	@Override
	public List<User> findByName(String name) {
		return repo.findByName(name);
	}

	@Override
	public Optional<User> findById(Long id) {
		return repo.findById(id);
	}

	@Override
	public Optional<User> findByEmail(String mail) {
		return repo.findByEmail(mail);
	}

	@Override
	public User createOrUpdate(User usr) {
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
