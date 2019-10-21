package com.inti.formation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entity.Station;
import com.inti.formation.iservice.IStationService;


@CrossOrigin("*")
@RestController
@RequestMapping("/apiStation")
public class StationController {
	
	private IStationService metier;
	
	 @RequestMapping(value="/ajouter", method=RequestMethod.POST)
	    public Station ajouter(@RequestBody Station s) {
	    	return metier.add(s);
	    }
	    
	    @RequestMapping(value="/update", method=RequestMethod.PUT)
	    public Station update(@RequestBody Station s) {
	    	return metier.update(s);
	    }
	    
	    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	    public Station getById(@PathVariable int id) {
	    	return metier.getById(id);
	    }
	    
	    @RequestMapping(value="/stations", method=RequestMethod.GET)
	    public List<Station> findAll() {
	    	return metier.findAll();
	    }
	    
	    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	    public void delete(@PathVariable int id) {
	    	metier.delete(id);
	    }


}
