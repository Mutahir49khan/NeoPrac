package com.neosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.Service.UserServiceClass;
import com.neosoft.model.User;

@RestController
@RequestMapping("/user")
public class Controller {
	@Autowired
	private UserServiceClass service;
	
	@GetMapping
	public String welcome() {
		
		return "Welcome Page of User";
	}
	
	@PostMapping("/register")
	public User registerTheUser(@RequestBody User jsonuser) {
		return service.createUser(jsonuser);
	}
	
	@GetMapping("/getAllUsers")
   public List<User> getAlltheUsers(){
		return service.getAllUser();
	}
	
	@GetMapping("/getById/{id}")
	public User getById(@PathVariable Long id) {
		return service.userById(id);
	}
	

}
