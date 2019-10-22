package com.inti.formation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entity.TransportEntreprise;
import com.inti.formation.iservice.ITransportEntrepriseService;

@CrossOrigin("*")
@RestController
@RequestMapping("/apiTransportEntreprise")
public class TransportEntrepriseController {
	
	private ITransportEntrepriseService metier;
	
	@RequestMapping(value="/ajouter", method=RequestMethod.POST)
    public TransportEntreprise ajouter(@RequestBody TransportEntreprise s) {
    	return metier.add(s);
    }
    
    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public TransportEntreprise update(@RequestBody TransportEntreprise s) {
    	return metier.update(s);
    }
    
    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public TransportEntreprise getById(@PathVariable int id) {
    	return metier.getById(id);
    }
    
    @RequestMapping(value="/transportEntreprises", method=RequestMethod.GET)
    public List<TransportEntreprise> findAll() {
    	return metier.findAll();
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
    	metier.delete(id);
    }

	
	

}
