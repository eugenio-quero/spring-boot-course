package com.eugenio.courses.springbootcourse.service.deployment;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;

import com.eugenio.courses.springbootcourse.model.Deployment;
import com.eugenio.courses.springbootcourse.model.enums.DeploymentStatus;
import com.eugenio.courses.springbootcourse.model.enums.Environment;

public interface DeploymentService {

	Deployment createOrUpdate(Deployment usr);
	HttpStatus delete(Long id);
	
	List<Deployment> findAll();
	Optional<Deployment> findById(Long id);
	List<Deployment> findByStatus(DeploymentStatus status);
	List<Deployment> findByEnvironment(Environment env);
	HttpStatus startDeployment(Long deploymentId);
}
