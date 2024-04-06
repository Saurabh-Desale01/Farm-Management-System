package com.example.farmmanagementsystem.dto;

import java.util.List;

import lombok.Data;

@Data
public class FarmDto {

	private Long farmId;
	private String name;
	private String location;
	private String type;
	
	//private User user;
	
	private List<FieldDto> field;

}
