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
import com.inti.formation.entity.SeatReservation;
import com.inti.formation.iservice.ISeatReservationService;

@CrossOrigin("*")
@RestController
@RequestMapping("/apiSeatReservation")
public class SeatReservationController {
	
	@Autowired
	private ISeatReservationService metier;
	
	@PostMapping(value="/add")
    public SeatReservation add(@RequestBody SeatReservation sr) {
    	return metier.add(sr);
    }
    
    @PutMapping(value="/update")
    public SeatReservation update(@RequestBody SeatReservation sr) {
    	return metier.update(sr);
    }
    
    @GetMapping(value="/get/{id}")
    public SeatReservation getById(@PathVariable int id) {
    	return metier.getById(id);
    }
    
    @GetMapping(value="/reservations")
    public List<SeatReservation> findAll() {
    	return metier.findAll();
    }
    
    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable int id) {
    	metier.delete(id);
    }


}
