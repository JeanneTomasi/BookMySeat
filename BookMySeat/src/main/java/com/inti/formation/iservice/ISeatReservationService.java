package com.inti.formation.iservice;

import java.util.List;

import com.inti.formation.entity.SeatReservation;



public interface ISeatReservationService {

	public SeatReservation add(SeatReservation sr);
	public SeatReservation update(SeatReservation sr);
	public void delete(int id);
	public SeatReservation getById(int id);
	public List<SeatReservation> findAll();
	
}
