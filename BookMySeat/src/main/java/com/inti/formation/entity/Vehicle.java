package com.inti.formation.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@ManyToOne
	@JoinColumn(name = "id_line")
	private Line line;
	@ManyToOne
	@JoinColumn(name = "id_transit_time")
	private TransitTime transit_time;
	
}
