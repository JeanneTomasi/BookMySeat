package com.inti.formation.entity;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	@Embedded
	private Adress adress;
	private String email;
	@Enumerated(EnumType.STRING)
	private Handicap handicap;
	private String username;
	@OneToOne(mappedBy = "user")
	private Seat seat;

}