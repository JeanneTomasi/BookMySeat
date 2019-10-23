package com.inti.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entity.TransportEntreprise;
import com.inti.formation.iservice.ITransportEntrepriseService;

@CrossOrigin("*")
@RestController
@RequestMapping("/apiTransportEntreprise")
public class TransportEntrepriseController {
	
	@Autowired
	private ITransportEntrepriseService metier;
	
	@PostMapping(value="/add")
    public TransportEntreprise ajouter(@RequestBody TransportEntreprise tre) {
    	return metier.add(tre);
    }
    
    @PutMapping(value="/update")
    public TransportEntreprise update(@RequestBody TransportEntreprise tre) {
    	return metier.update(tre);
    }
    
    @GetMapping(value="/get/{id}")
    public TransportEntreprise getById(@PathVariable int id) {
    	return metier.getById(id);
    }
    
    @GetMapping(value="/transportEntreprises")
    public List<TransportEntreprise> findAll() {
    	return metier.findAll();
    }
    
    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable int id) {
    	metier.delete(id);
    }

	
	

}
