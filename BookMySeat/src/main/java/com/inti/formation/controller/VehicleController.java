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

import com.inti.formation.entity.Vehicle;
import com.inti.formation.iservice.IVehicleService;


@CrossOrigin("*")
@RestController
@RequestMapping("/apiVehicle")
public class VehicleController {
	
    @Autowired
    private IVehicleService metier;
    
    @PostMapping(value="/add")
    public Vehicle ajouter(@RequestBody Vehicle v) {
    	return metier.add(v);
    }
    
    @PutMapping(value="/update")
    public Vehicle update(@RequestBody Vehicle v) {
    	return metier.update(v);
    }
    
    @GetMapping(value="/get/{id}")
    public Vehicle getById(@PathVariable int id) {
    	return metier.getById(id);
    }
    
    @GetMapping(value="/vehicles")
    public List<Vehicle> findAll() {
    	return metier.findAll();
    }
    
    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable int id) {
    	metier.delete(id);
    }


}