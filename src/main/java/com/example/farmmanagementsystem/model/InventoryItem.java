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
public class InventoryItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	private String name;
	private Integer quantity;
	private Double unitPrice;
	private LocalDate purchaseDate;
	
//	@ManyToOne
//	@JoinColumn(name = "farm_id")
//	private Farm farm;
}
