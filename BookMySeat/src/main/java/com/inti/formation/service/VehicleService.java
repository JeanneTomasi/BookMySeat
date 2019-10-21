package com.inti.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inti.formation.entity.Vehicle;
import com.inti.formation.iservice.IVehicleService;
import com.inti.formation.repository.IVehicleRepository;

public class VehicleService implements IVehicleService {

	@Autowired
	private IVehicleRepository repo;
	
	@Override
	public Vehicle ajouter(Vehicle v) {
		return repo.save(v);
	}

	@Override
	public Vehicle update(Vehicle v) {
		return repo.save(v);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);		
	}

	@Override
	public Vehicle getById(int id) {
		return repo.getOne(id);
	}

	@Override
	public List<Vehicle> findAll() {
		return repo.findAll();
	}

}
