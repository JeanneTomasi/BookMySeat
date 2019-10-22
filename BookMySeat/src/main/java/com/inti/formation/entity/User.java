package com.inti.formation.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
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
	@Temporal(value=TemporalType.DATE)
	private Date dateDeNaissance;
	@Embedded
	private Adress adress;
	private String email;
	@Enumerated(EnumType.STRING)
	private Handicap handicap;
	private String username;
	@OneToOne(mappedBy = "user")
	private Seat seat;

}
