package com.inti.formation.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id_vehicle;
	private String immatriculation;
	private int placesNumber;
	private int placesLeft;
	private double fullRate;
	@OneToMany(mappedBy = "vehicle")
	private Seat seat;
	@OneToMany(mappedBy = "id_vehicles")
	private List<TablePorteuseStation_Line_Vehicle> arrets;
	
}
