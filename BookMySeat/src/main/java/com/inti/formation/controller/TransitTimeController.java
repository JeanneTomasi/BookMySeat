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

import com.inti.formation.entity.TransitTime;
import com.inti.formation.iservice.ITransitTimeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/apiTransitTime")
public class TransitTimeController {
	
	private ITransitTimeService metier;
	
	@PostMapping(value="/add")
    public TransitTime add(@RequestBody TransitTime tt) {
    	return metier.add(tt);
    }
    
    @PutMapping(value="/update")
    public TransitTime update(@RequestBody TransitTime tt) {
    	return metier.update(tt);
    }
    
    @GetMapping(value="/get/{id}")
    public TransitTime getById(@PathVariable int id) {
    	return metier.getById(id);
    }
    
    @GetMapping(value="/transitTimes")
    public List<TransitTime> findAll() {
    	return metier.findAll();
    }
    
	@DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable int id) {
    	metier.delete(id);
    }


}
