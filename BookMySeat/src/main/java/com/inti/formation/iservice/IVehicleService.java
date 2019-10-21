package com.inti.formation.iservice;

import java.util.List;

import com.inti.formation.entity.Vehicle;

public interface IVehicleService {
	
	public Vehicle ajouter(Vehicle v);
	public Vehicle update(Vehicle v);
	public void delete(int id);
	public Vehicle getById(int id);
	public List<Vehicle> findAll();

}
