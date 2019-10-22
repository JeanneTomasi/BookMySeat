package com.inti.formation.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TablePorteuse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TablePorteuseStation_Line_Vehicle {
	
	@EmbeddedId
	private TablePorteuseId id_tablePorteuse;
	private String heureDePassage;

}
