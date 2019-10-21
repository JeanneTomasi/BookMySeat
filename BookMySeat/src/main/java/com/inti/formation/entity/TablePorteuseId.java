package com.inti.formation.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class TablePorteuseId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn (name = "id_station")
	private int id_station;
	@ManyToOne
	@JoinColumn (name = "id_line")
	private int id_line;
	@ManyToOne
	@JoinColumn (name = "id_vehicle")
	private int id_vehicle;

}
