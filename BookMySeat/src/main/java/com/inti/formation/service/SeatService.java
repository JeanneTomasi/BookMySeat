package com.inti.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inti.formation.entity.Seat;
import com.inti.formation.iservice.ISeatService;
import com.inti.formation.iservice.IVehicleService;
import com.inti.formation.repository.ISeatRepository;

public class SeatService implements ISeatService {
	
	@Autowired
	private ISeatRepository repo;


	@Override
	public Seat ajouter(Seat s) {
		return repo.save(s);
	}

	@Override
	public Seat update(Seat s) {
		return repo.save(s);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);		
	}

	@Override
	public Seat getById(int id) {
		return repo.getOne(id);
	}

	@Override
	public List<Seat> findAll() {
		return repo.findAll();
	}

}
