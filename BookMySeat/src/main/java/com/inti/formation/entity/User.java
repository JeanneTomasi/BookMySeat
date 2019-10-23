package com.inti.formation.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id_user;
	private String name;
	private String firstName;
	private LocalDate dateDeNaissance;
	private int num;
	private String street;
	private String city;
	private int postalCode;
	private String country;
	private String email;
	@Enumerated(EnumType.STRING)
	private Handicap handicap;
	private String username;
	@OneToOne(mappedBy = "user")
	private Seat seat;
	@OneToMany(mappedBy = "user")
	private List<SeatReservation> seat_reservation;

}
