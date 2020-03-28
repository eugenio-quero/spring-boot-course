package com.eugenio.courses.springbootcourse.controller.deployment;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eugenio.courses.springbootcourse.model.Deployment;
import com.eugenio.courses.springbootcourse.model.enums.DeploymentStatus;
import com.eugenio.courses.springbootcourse.model.enums.Environment;
import com.eugenio.courses.springbootcourse.service.deployment.DeploymentService;

@RestController
@RequestMapping("/api/deployment")
public class DeploymentController {

    DeploymentService service;
    
	
	public DeploymentController(DeploymentService service) {
		super();
		this.service = service;
	}

	@GetMapping(value={"", "/"})
    public List<Deployment> getDeployments() {
        return service.findAll();
    }
	
	@GetMapping("/id/{id}")
    public Optional<Deployment> getDeploymentById(@PathVariable long id) {
		return  service.findById(id);
    }
	
	@GetMapping("/environment/{env}")
    public List<Deployment> getDeploymentsByName(@PathVariable Environment env) {
        return service.findByEnvironment(env);
    }
	
	@GetMapping("/status/{status}")
    public List<Deployment> getDeploymentsByName(@PathVariable DeploymentStatus status) {
        return service.findByStatus(status);
    }
	
    @PostMapping("/createOrUpdate")
    public Deployment createOrUpdate(@RequestBody Deployment deployment) {
        return service.createOrUpdate(deployment);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable long id) {
    		return service.delete(id);
    }
	
    @PostMapping({"/start/", "/start"})
    public HttpStatus start(@RequestBody Deployment dep) {
    		return service.startDeployment(dep.getId());
    }
	
}
