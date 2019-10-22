package com.inti.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entity.User;
import com.inti.formation.iservice.IUserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/apiUser")
public class UserController {
	
	@Autowired
	private IUserService metier;
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public User add(@RequestBody User u) {
		return metier.add(u);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public User update(@RequestBody User u) {
		return metier.update(u);
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public User getById(@PathVariable int id) {
		return metier.getById(id);
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> findAll(){
		return metier.findAll();
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		metier.delete(id);
	}

}
