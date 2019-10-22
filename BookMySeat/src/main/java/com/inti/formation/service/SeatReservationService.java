package com.inti.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entity.SeatReservation;
import com.inti.formation.iservice.ISeatReservationService;
import com.inti.formation.repository.ISeatReservationRepository;

@Service
public class SeatReservationService implements ISeatReservationService{

	@Autowired
	private ISeatReservationRepository repo;
	
	@Override
	public SeatReservation add(SeatReservation sr) {
		
		return repo.save(sr);
	}

	@Override
	public SeatReservation update(SeatReservation sr) {
		
		return repo.save(sr);
	}

	@Override
	public void delete(int id) {

		repo.deleteById(id);
	}

	@Override
	public SeatReservation getById(int id) {
	
		return repo.getOne(id);
	}

	@Override
	public List<SeatReservation> findAll() {
		
		return repo.findAll();
	}

}
