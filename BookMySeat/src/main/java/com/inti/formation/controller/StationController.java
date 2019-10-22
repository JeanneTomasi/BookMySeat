package com.inti.formation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entity.Station;
import com.inti.formation.iservice.IStationService;


@CrossOrigin("*")
@RestController
@RequestMapping("/apiStation")
public class StationController {
	
	private IStationService metier;
	
	 @PostMapping(value="/add")
	    public Station add(@RequestBody Station s) {
	    	return metier.add(s);
	    }
	    
	    @PutMapping(value="/update")
	    public Station update(@RequestBody Station s) {
	    	return metier.update(s);
	    }
	    
	    @GetMapping(value="/get/{id}")
	    public Station getById(@PathVariable int id) {
	    	return metier.getById(id);
	    }
	    
	    @GetMapping(value="/stations")
	    public List<Station> findAll() {
	    	return metier.findAll();
	    }
	    
	    @DeleteMapping(value="/delete/{id}")
	    public void delete(@PathVariable int id) {
	    	metier.delete(id);
	    }


}
