package com.inti.formation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entity.Station;
import com.inti.formation.entity.TablePorteuseId;
import com.inti.formation.entity.TablePorteuseStation_Line_Vehicle;
import com.inti.formation.iservice.IStationService;
import com.inti.formation.iservice.ITablePorteuseService;

@CrossOrigin("*")
@RestController
@RequestMapping("/apiTablePorteuse")
public class TablePorteuseController {
	
	private ITablePorteuseService metier;
	
	 @RequestMapping(value="/add", method=RequestMethod.POST)
	    public TablePorteuseStation_Line_Vehicle add(@RequestBody TablePorteuseStation_Line_Vehicle tp) {
	    	return metier.add(tp);
	    }
	    
	    @RequestMapping(value="/update", method=RequestMethod.PUT)
	    public TablePorteuseStation_Line_Vehicle update(@RequestBody TablePorteuseStation_Line_Vehicle tp) {
	    	return metier.update(tp);
	    }
	    
	    @RequestMapping(value="/get/{id_station}/{id_line}/{id_vehicle}", method=RequestMethod.GET)
	    public TablePorteuseStation_Line_Vehicle getById(@PathVariable TablePorteuseId id) {
	    	return metier.getById(id);
	    }
	    
	    @RequestMapping(value="/tableporteuses", method=RequestMethod.GET)
	    public List<TablePorteuseStation_Line_Vehicle> findAll() {
	    	return metier.findAll();
	    }
	    
	    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	    public void delete(@PathVariable TablePorteuseId id) {
	    	metier.delete(id);
	    }


}
