package com.inti.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inti.formation.entity.TransitTime;
import com.inti.formation.iservice.ITransitTimeService;
import com.inti.formation.repository.ITransitTimeRepository;

public class TransitTimeService implements ITransitTimeService {

	@Autowired
	private ITransitTimeRepository repo;
	
	@Override
	public TransitTime add(TransitTime tt) {
		return repo.save(tt) ;
	}

	@Override
	public TransitTime update(TransitTime tt) {
		return repo.save(tt);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}

	@Override
	public TransitTime getById(int id) {
		return repo.getOne(id);
	}

	@Override
	public List<TransitTime> findAll() {
		return repo.findAll();
	}

}
