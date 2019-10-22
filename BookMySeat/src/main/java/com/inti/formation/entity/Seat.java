package com.inti.formation.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inti.formation.entity.Vehicle.VehicleBuilder;

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
public class Seat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id_seat;
	private String placement;
	private boolean reservable;
	private boolean isReserved;
	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;
	@ManyToOne
	@JoinColumn(name = "id_vehicle")
	private Vehicle vehicle;
	@OneToMany(mappedBy = "seat")
	private List<SeatReservation> seat_reservation;
}
