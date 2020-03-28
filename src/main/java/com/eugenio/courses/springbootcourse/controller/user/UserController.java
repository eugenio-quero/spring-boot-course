package com.eugenio.courses.springbootcourse.controller.user;

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

import com.eugenio.courses.springbootcourse.model.User;
import com.eugenio.courses.springbootcourse.service.user.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    UserService service;
    
	
	public UserController(UserService service) {
		super();
		this.service = service;
	}

	@GetMapping(value={"", "/"})
    public List<User> getUsers() {
        return service.findAll();
    }
	
	@GetMapping("/id/{id}")
    public Optional<User> getUserById(@PathVariable long id) {
		return  service.findById(id);
    }
	
	@GetMapping("/name/{name}")
    public List<User> getUsersByName(@PathVariable String name) {
        return service.findByName(name);
    }
	
    @PostMapping("/createOrUpdate")
    public User createOrUpdate(@RequestBody User user) {
        return service.createOrUpdate(user);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable long id) {
    		return service.delete(id);
    }
	
	
}
