package com.inti.formation.entity;


import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Adress {
	
	private int num;
	private String street;
	private String city;
	private int postalCode;
	private String country;

}
