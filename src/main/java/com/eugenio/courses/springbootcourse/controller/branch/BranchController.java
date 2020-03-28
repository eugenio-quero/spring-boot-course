package com.eugenio.courses.springbootcourse.controller.branch;

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

import com.eugenio.courses.springbootcourse.model.Branch;
import com.eugenio.courses.springbootcourse.service.branch.BranchService;

@RestController
@RequestMapping("/api/branch")
public class BranchController {

    BranchService service;
    
	
	public BranchController(BranchService service) {
		super();
		this.service = service;
	}

	@GetMapping(value={"", "/"})
    public List<Branch> getBranchs() {
        return service.findAll();
    }
	
	@GetMapping("/id/{id}")
    public Optional<Branch> getBranchById(@PathVariable long id) {
		return  service.findById(id);
    }
	
	@GetMapping("/name/{name}")
    public List<Branch> getBranchsByName(@PathVariable String name) {
        return service.findByName(name);
    }
	
    @PostMapping("/createOrUpdate")
    public Branch createOrUpdate(@RequestBody Branch Branch) {
        return service.createOrUpdate(Branch);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable long id) {
    		return service.delete(id);
    }
	
	
}
