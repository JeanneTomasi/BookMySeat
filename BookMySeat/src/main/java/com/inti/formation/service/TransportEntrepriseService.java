package com.inti.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entity.TransportEntreprise;
import com.inti.formation.iservice.ITransportEntrepriseService;
import com.inti.formation.repository.ITransportEntrepriseRepository;

@Service
public class TransportEntrepriseService implements ITransportEntrepriseService {

	@Autowired
	private ITransportEntrepriseRepository repo;
	
	@Override
	public TransportEntreprise add(TransportEntreprise tre) {
		
		return repo.save(tre);
	}

	@Override
	public TransportEntreprise update(TransportEntreprise tre) {
		
		return repo.save(tre);
	}

	@Override
	public void delete(int id) {

		repo.deleteById(id);
	}

	@Override
	public TransportEntreprise getById(int id) {
		
		return repo.getOne(id);
	}

	@Override
	public List<TransportEntreprise> findAll() {
		
		return repo.findAll();
	}

}
