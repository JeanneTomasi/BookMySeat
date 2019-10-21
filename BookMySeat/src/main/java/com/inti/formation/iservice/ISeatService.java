package com.inti.formation.iservice;

import java.util.List;

import com.inti.formation.entity.Seat;

public interface ISeatService {
	
	public Seat ajouter(Seat s);
	public Seat update(Seat s);
	public void delete(int id);
	public Seat getById(int id);
	public List<Seat> findAll();

}
