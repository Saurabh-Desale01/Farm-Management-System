package com.example.farmmanagementsystem.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class InventoryItemDto {

	private Long itemId;
	private String name;
	private Integer quantity;
	private Double unitPrice;
	private LocalDate purchaseDate;
}
