package com.inti.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entity.Station;
import com.inti.formation.iservice.IStationService;
import com.inti.formation.repository.IStationRepository;

@Service
public class StationService implements IStationService {

	@Autowired
	private IStationRepository repo;
	
	@Override
	public Station add(Station s) {
		
		return repo.save(s);
	}

	@Override
	public Station update(Station s) {
		
		return repo.save(s);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public Station getById(int id) {
		
		return repo.getOne(id);
	}

	@Override
	public List<Station> findAll() {
		
		return repo.findAll();
	}

}
