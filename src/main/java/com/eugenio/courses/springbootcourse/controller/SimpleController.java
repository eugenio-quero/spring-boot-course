package com.eugenio.courses.springbootcourse.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.eugenio.courses.springbootcourse.service.branch.BranchService;
import com.eugenio.courses.springbootcourse.service.deployment.DeploymentService;
import com.eugenio.courses.springbootcourse.service.user.UserService;

@Controller
public class SimpleController {

    @Value("${spring.application.name}")
    String appName;
    
    DeploymentService deploymentService;
    UserService userService;
    BranchService branchService;
    
	public SimpleController(DeploymentService deploymentService, UserService userService, BranchService branchService) {
		super();
		this.deploymentService = deploymentService;
		this.userService = userService;
		this.branchService = branchService;
	}

	@GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }
	
    @GetMapping({"/deployments/", "/deployments"})
    public String deploymentsList(Model model) {
    		model.addAttribute("deployments", deploymentService.findAll());
    		return "deployments";
    }
    
    @GetMapping({"/users/", "/users"})
    public String usersList(Model model) {
    		model.addAttribute("users", userService.findAll());
    		return "users";
    }
    
    @GetMapping({"/branches/", "/branches"})
    public String branchesList(Model model) {
    		model.addAttribute("branches", branchService.findAll());
    		return "branches";
    }
    
}
