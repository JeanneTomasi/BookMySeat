package com.inti.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entity.User;
import com.inti.formation.iservice.IUserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/apiUser")
public class UserController {
	
	@Autowired
	private IUserService metier;
	
	@PostMapping(value="/add")
	public User add(@RequestBody User u) {
		return metier.add(u);
	}
	
	@PutMapping(value="/update")
	public User update(@RequestBody User u) {
		return metier.update(u);
	}
	
	@GetMapping(value = "/get/{id}")
	public User getById(@PathVariable int id) {
		return metier.getById(id);
	}
	
	@GetMapping(value = "/users")
	public List<User> findAll(){
		return metier.findAll();
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable int id) {
		metier.delete(id);
	}

}
