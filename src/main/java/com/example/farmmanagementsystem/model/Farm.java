package com.example.farmmanagementsystem.model;

import java.util.List;

import jakarta.persistence.Entity;
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
public class Farm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long farmId;
	private String name;
	private String location;
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "farm")
	private List<Field> field;
	
//	@OneToMany(mappedBy = "farm")
//	private List<InventoryItem> inventoryItem;
//	
//	@OneToMany(mappedBy = "farm")
//	private List<Equipment> equipment;
	
}
