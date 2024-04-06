package com.example.farmmanagementsystem.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Equipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long euipmentId;
	private String name;
	private String type;
	private LocalDate purchaseDate;
	private LocalDate maintenanceDate;
	
//	@ManyToOne
//	@JoinColumn(name = "farm_id")
//	private Farm farm;
}
