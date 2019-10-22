package com.inti.formation.iservice;

import java.util.List;

import com.inti.formation.entity.TransitTime;

public interface ITransitTimeService {
	
	public TransitTime add(TransitTime tt);
    public TransitTime update(TransitTime tt);
    public void delete(int id);
    public TransitTime getById(int id);
    public List<TransitTime> findAll();


}
