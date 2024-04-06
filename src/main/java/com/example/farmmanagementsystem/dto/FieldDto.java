package com.example.farmmanagementsystem.dto;

import java.util.List;
import lombok.Data;

@Data
public class FieldDto {

	private Long fieldId;
	private String name;
	private Double size;
	
	private List<CropDto> crop;
}
