package com.inti.formation.iservice;

import java.util.List;


import com.inti.formation.entity.Station;

public interface IStationService {
	
	public Station add(Station s);
    public Station update(Station s);
    public void delete(int id);
    public Station getById(int id);
    public List<Station> findAll();


}
