package com.inti.formation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entity.TransitTime;
import com.inti.formation.iservice.ITransitTimeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/apiTransitTime")
public class TransitTimeController {
	
	private ITransitTimeService metier;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
    public TransitTime add(@RequestBody TransitTime tt) {
    	return metier.add(tt);
    }
    
    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public TransitTime update(@RequestBody TransitTime tt) {
    	return metier.update(tt);
    }
    
    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public TransitTime getById(@PathVariable int id) {
    	return metier.getById(id);
    }
    
    @RequestMapping(value="/transitTimes", method=RequestMethod.GET)
    public List<TransitTime> findAll() {
    	return metier.findAll();
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
    	metier.delete(id);
    }


}
