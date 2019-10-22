package com.inti.formation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entity.Collectivity;
import com.inti.formation.iservice.ICollectivityService;

@CrossOrigin("*")
@RestController
@RequestMapping("/apiCollectivity")
public class CollectivityController {

	private ICollectivityService metier;
	
    @RequestMapping(value="/ajouter", method=RequestMethod.POST)
    public Collectivity ajouter(@RequestBody Collectivity c) {
    	return metier.add(c);
    }
    
    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public Collectivity update(@RequestBody Collectivity c) {
    	return metier.update(c);
    }
    
    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public Collectivity getById(@PathVariable int id) {
    	return metier.getById(id);
    }
    
    @RequestMapping(value="/collectivities", method=RequestMethod.GET)
    public List<Collectivity> findAll() {
    	return metier.findAll();
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
    	metier.delete(id);
    }

}
