package com.example.farmmanagementsystem.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ExpenseDto {

	private Long expenseId;
	private String description;
	private Double amount;
	private LocalDate expenseDate;
	private Long cropId;
}
