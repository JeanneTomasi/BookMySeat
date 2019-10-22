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

import com.inti.formation.entity.Collectivity;
import com.inti.formation.iservice.ICollectivityService;

@CrossOrigin("*")
@RestController
@RequestMapping("/apiCollectivity")
public class CollectivityController {

	private ICollectivityService metier;
	
    @PostMapping(value="/add")
    public Collectivity ajouter(@RequestBody Collectivity c) {
    	return metier.add(c);
    }
    
    @PutMapping(value="/update")
    public Collectivity update(@RequestBody Collectivity c) {
    	return metier.update(c);
    }
    
    @GetMapping(value="/get/{id}")
    public Collectivity getById(@PathVariable int id) {
    	return metier.getById(id);
    }
    
    @GetMapping(value="/collectivities")
    public List<Collectivity> findAll() {
    	return metier.findAll();
    }
    
    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable int id) {
    	metier.delete(id);
    }

}
