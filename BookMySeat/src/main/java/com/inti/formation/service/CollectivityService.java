package com.inti.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entity.Collectivity;
import com.inti.formation.iservice.ICollectivityService;
import com.inti.formation.repository.ICollectivityRepository;

@Service
public class CollectivityService implements ICollectivityService {

	@Autowired
	private ICollectivityRepository repo;

	@Override
	public Collectivity add(Collectivity c) {

		return repo.save(c);
	}

	@Override
	public Collectivity update(Collectivity c) {

		return repo.save(c);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);

	}

	@Override
	public Collectivity getById(int id) {

		return repo.getOne(id);
	}

	@Override
	public List<Collectivity> findAll() {

		return repo.findAll();
	}

}
