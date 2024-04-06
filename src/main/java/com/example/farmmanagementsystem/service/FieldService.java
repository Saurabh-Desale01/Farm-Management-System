package com.example.farmmanagementsystem.service;

import java.util.List;

import com.example.farmmanagementsystem.dto.FieldDto;


public interface FieldService {

	FieldDto getFieldById(Long fieldId);

	List<FieldDto> getAllFields();

	FieldDto saveField(Long farmId, FieldDto field);

	FieldDto updateField(Long fieldId, FieldDto fieldDto);

	void deleteField(Long fieldId);
	
	List<FieldDto> getAllFieldsWithCrops();

	//List<FieldDto> getAllFields();
}
