package com.eugenio.courses.springbootcourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eugenio.courses.springbootcourse.model.Deployment;
import com.eugenio.courses.springbootcourse.model.enums.DeploymentStatus;
import com.eugenio.courses.springbootcourse.model.enums.Environment;

public interface DeploymentRepository extends JpaRepository	<Deployment, Long> {
	
	List<Deployment> findByBranch(Long branchId);
	List<Deployment> findByStatus(DeploymentStatus status);
	List<Deployment> findByEnvironment(Environment env);
}
