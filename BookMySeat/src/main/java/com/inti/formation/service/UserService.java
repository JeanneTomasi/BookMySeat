package com.inti.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entity.User;
import com.inti.formation.iservice.IUserService;
import com.inti.formation.repository.IUserRepository;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserRepository repo;
	
	@Override
	public User add(User u) {
		return repo.save(u);
	}

	@Override
	public User update(User u) {
		return repo.save(u);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public User getById(int id) {
		return repo.getOne(id);
	}

	@Override
	public List<User> findAll() {
		return repo.findAll();
	}

}
