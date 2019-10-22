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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entity.Line;
import com.inti.formation.iservice.ILineService;


@CrossOrigin("*")
@RestController
@RequestMapping("/apiLine")
public class LineController {
	
    @Autowired
    private ILineService metier;
    
    @PostMapping(value="/add")
    public Line ajouter(@RequestBody Line l) {
    	return metier.add(l);
    }
    
    @PutMapping(value="/update")
    public Line update(@RequestBody Line l) {
    	return metier.update(l);
    }
    
    @GetMapping(value="/get/{id}")
    public Line getById(@PathVariable int id) {
    	return metier.getById(id);
    }
    
    @GetMapping(value="/Lines")
    public List<Line> findAll() {
    	return metier.findAll();
    }
    
    @DeleteMapping(value="/delete/{id}")
    public void delete(@PathVariable int id) {
    	metier.delete(id);
    }


}