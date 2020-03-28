package com.eugenio.courses.springbootcourse.service.deployment;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.eugenio.courses.springbootcourse.model.Deployment;
import com.eugenio.courses.springbootcourse.model.enums.DeploymentStatus;
import com.eugenio.courses.springbootcourse.model.enums.Environment;
import com.eugenio.courses.springbootcourse.repository.DeploymentRepository;

@Service
public class DeploymentServiceImp implements DeploymentService{

	DeploymentRepository repo;
	
	
	public DeploymentServiceImp(DeploymentRepository repo) {
		super();
		this.repo = repo;
	}


	@Override
	public Deployment createOrUpdate(Deployment dep) {
		return repo.save(dep);
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


	@Override
	public List<Deployment> findAll() {
		return repo.findAll();
	}


	@Override
	public Optional<Deployment> findById(Long id) {
		return repo.findById(id);
	}

	@Override
	public List<Deployment> findByStatus(DeploymentStatus status) {
		return repo.findByStatus(status);
	}


	@Override
	public List<Deployment> findByEnvironment(Environment env) {
		return repo.findByEnvironment(env);
	}


	@Override
	public HttpStatus startDeployment(Long deploymentId) {
		Optional<Deployment> deployment = repo.findById(deploymentId);
		if(deployment.isPresent()) {
			deployment.get().setStatus(DeploymentStatus.IN_PROGRESS);
			repo.save(deployment.get());
			return HttpStatus.OK;
		}else {
			return HttpStatus.NOT_FOUND;
		}
	}

	
}
