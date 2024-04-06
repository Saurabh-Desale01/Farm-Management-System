package com.example.farmmanagementsystem.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Crop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cropId;
	private String name;
	private LocalDate plantingDate;
	private LocalDate harvestingDate;
	private String status;
	
//	@ManyToOne
//	@JoinColumn(name = "task_id")
//	private Task task;
	
	@OneToMany(mappedBy = "crop")
	private List<Expense> expense;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "field_id", nullable = false)
	private Field field;
}
