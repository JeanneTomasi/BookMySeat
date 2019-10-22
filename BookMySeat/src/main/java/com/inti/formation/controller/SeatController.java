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

import com.inti.formation.entity.Seat;
import com.inti.formation.iservice.ISeatService;


@CrossOrigin("*")
@RestController
@RequestMapping("/apiSeat")
public class SeatController {
	
    @Autowired
    private ISeatService metier;
    
    @PostMapping(value="/add")
    public Seat ajouter(@RequestBody Seat s) {
    	return metier.add(s);
    }
    
    @PutMapping(value="/update")
    public Seat update(@RequestBody Seat s) {
    	return metier.update(s);
    }
    
    @GetMapping(value="/get/{id}")
    public Seat getById(@PathVariable int id) {
    	return metier.getById(id);
    }
    
    @GetMapping(value="/seats")
    public List<Seat> findAll() {
    	return metier.findAll();
    }
    
    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable int id) {
    	metier.delete(id);
    }


}