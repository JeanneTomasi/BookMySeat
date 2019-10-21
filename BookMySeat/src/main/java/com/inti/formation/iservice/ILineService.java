package com.inti.formation.iservice;

import java.util.List;

import com.inti.formation.entity.Line;

public interface ILineService {
	
	public Line add(Line l);
	public Line update(Line l);
	public void delete(int id);
	public Line getById(int id);
	public List<Line> findAll();

}
