package com.example.farmmanagementsystem.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EquipmentDto {

	private Long euipmentId;
	private String name;
	private String type;
	private LocalDate purchaseDate;
	private LocalDate maintenanceDate;
}
