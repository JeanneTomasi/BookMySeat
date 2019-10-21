package com.inti.formation.iservice;

import java.util.List;

import com.inti.formation.entity.TransportEntreprise;


public interface ITransportEntrepriseService {

	public TransportEntreprise add(TransportEntreprise tre);
    public TransportEntreprise update(TransportEntreprise tre);
    public void delete(int id);
    public TransportEntreprise getById(int id);
    public List<TransportEntreprise> findAll();

	
}
