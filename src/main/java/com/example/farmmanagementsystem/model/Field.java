package com.example.farmmanagementsystem.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Field {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fieldId;
	private String name;
	private Double size;
	
	@OneToMany(mappedBy = "field", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Crop> crop = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "farm_id")
	private Farm farm;
}
