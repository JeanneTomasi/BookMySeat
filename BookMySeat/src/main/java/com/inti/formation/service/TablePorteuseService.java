package com.inti.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entity.TablePorteuseId;
import com.inti.formation.entity.TablePorteuseStation_Line_Vehicle;
import com.inti.formation.iservice.ITablePorteuseService;
import com.inti.formation.repository.ITablePorteuseRepository;

@Service
public class TablePorteuseService implements ITablePorteuseService {
	
	@Autowired
	private ITablePorteuseRepository repo;

	@Override
	public TablePorteuseStation_Line_Vehicle add(TablePorteuseStation_Line_Vehicle tp) {
		return repo.save(tp);
	}

	@Override
	public TablePorteuseStation_Line_Vehicle update(TablePorteuseStation_Line_Vehicle tp) {
		return repo.save(tp);
	}

	@Override
	public void delete(TablePorteuseId tpId) {
		repo.deleteById(tpId);

	}

	@Override
	public TablePorteuseStation_Line_Vehicle getById(TablePorteuseId tpId) {
		return repo.getOne(tpId);
	}

	@Override
	public List<TablePorteuseStation_Line_Vehicle> findAll() {
		return repo.findAll();
	}

}
