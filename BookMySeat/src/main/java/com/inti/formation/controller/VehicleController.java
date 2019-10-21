package com.inti.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entity.Vehicle;
import com.inti.formation.iservice.IVehicleService;


@CrossOrigin("*")
@RestController
@RequestMapping("/apiVehicle")
public class VehicleController {
	
    @Autowired
    private IVehicleService metier;
    
    @RequestMapping(value="/ajouter", method=RequestMethod.POST)
    public Vehicle ajouter(@RequestBody Vehicle s) {
    	return metier.ajouter(s);
    }
    
    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public Vehicle update(@RequestBody Vehicle s) {
    	return metier.update(s);
    }
    
    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public Vehicle getById(@PathVariable int id) {
    	return metier.getById(id);
    }
    
    @RequestMapping(value="/vehicles", method=RequestMethod.GET)
    public List<Vehicle> findAll() {
    	return metier.findAll();
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
    	metier.delete(id);
    }


}