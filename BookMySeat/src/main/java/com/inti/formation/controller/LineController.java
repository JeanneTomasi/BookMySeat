package com.inti.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @RequestMapping(value="/ajouter", method=RequestMethod.POST)
    public Line ajouter(@RequestBody Line s) {
    	return metier.add(s);
    }
    
    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public Line update(@RequestBody Line s) {
    	return metier.update(s);
    }
    
    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public Line getById(@PathVariable int id) {
    	return metier.getById(id);
    }
    
    @RequestMapping(value="/Lines", method=RequestMethod.GET)
    public List<Line> findAll() {
    	return metier.findAll();
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
    	metier.delete(id);
    }


}