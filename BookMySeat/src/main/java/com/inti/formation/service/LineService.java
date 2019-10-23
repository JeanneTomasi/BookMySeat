package com.inti.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entity.Line;
import com.inti.formation.iservice.ILineService;
import com.inti.formation.repository.ILineRepository;

@Service
public class LineService implements ILineService {

	@Autowired
	private ILineRepository repo;

	@Override
	public Line add(Line l) {
		return repo.save(l);
	}

	@Override
	public Line update(Line l) {
		return repo.save(l);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}

	@Override
	public Line getById(int id) {
		return repo.getOne(id);		
	}

	@Override
	public List<Line> findAll() {
		return repo.findAll();
	}

}
