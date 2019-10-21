package com.inti.formation.iservice;

import java.util.List;

import com.inti.formation.entity.User;

public interface IUserService {

	public User add(User u);
	public User update(User u);
	public void delete(int id);
	public User getById(int id);
	public List<User> findAll();
	
}
