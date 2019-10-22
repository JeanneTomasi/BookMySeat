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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
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
	//Nombre total de places assises et debout prévues dans le véhicule
	private int capacity;
	//Nombre effectif de passagers dans le bus à un instant T
	private int passengers;
	//Nombre de places disponibles, assises ou debout confondues (exclues les places réservables) calculé à partir de capacity et passengers 
	private int placesLeft;
	//Taux de remplissage du véhicule, calculé à partir de capacity et passengers
	private double fullRate;
	@OneToMany(mappedBy = "vehicle")
	private List<Seat> seat;
	@OneToMany(mappedBy = "id_vehicles")
	private List<TablePorteuseStation_Line_Vehicle> arrets;
	
//	public void fullRateValue(){
//		this.placesLeft = this.capacity-this.passengers;
//		this.fullRate = this.passengers/this.capacity*100;
//	}
	
}
