package com.example.farmmanagementsystem.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;
	private String description;
	private String status;
	private LocalDate dueDate;
	private LocalDate completionDate;
	
	@ManyToOne
	@JoinColumn(name = "farm_id")
	private Farm farm;
	
//	@OneToMany(mappedBy = "task")
//    private List<Crop> crop;
}
