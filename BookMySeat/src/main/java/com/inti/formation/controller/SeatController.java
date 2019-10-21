package com.inti.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entity.Seat;
import com.inti.formation.iservice.ISeatService;


@CrossOrigin("*")
@RestController
@RequestMapping("/apiSeat")
public class SeatController {
	
    @Autowired
    private ISeatService metier;
    
    @RequestMapping(value="/ajouter", method=RequestMethod.POST)
    public Seat ajouter(@RequestBody Seat s) {
    	return metier.add(s);
    }
    
    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public Seat update(@RequestBody Seat s) {
    	return metier.update(s);
    }
    
    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public Seat getById(@PathVariable int id) {
    	return metier.getById(id);
    }
    
    @RequestMapping(value="/seats", method=RequestMethod.GET)
    public List<Seat> findAll() {
    	return metier.findAll();
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
    	metier.delete(id);
    }


}