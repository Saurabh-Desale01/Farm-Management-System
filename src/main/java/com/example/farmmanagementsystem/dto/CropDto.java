package com.example.farmmanagementsystem.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class CropDto {

	private Long cropId;
	private String name;
	private LocalDate plantingDate;
	private LocalDate harvestingDate;
	private String status;
	private Long fieldId;
	
	List<ExpenseDto> expense; 
}
