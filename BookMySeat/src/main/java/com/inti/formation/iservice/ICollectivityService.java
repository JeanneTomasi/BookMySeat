package com.inti.formation.iservice;

import java.util.List;

import com.inti.formation.entity.Collectivity;

public interface ICollectivityService {
	
	public Collectivity add(Collectivity c);
    public Collectivity update(Collectivity c);
    public void delete(int id);
    public Collectivity getById(int id);
    public List<Collectivity> findAll();


}
