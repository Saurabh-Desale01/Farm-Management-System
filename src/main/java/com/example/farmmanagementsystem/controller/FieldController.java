package com.example.farmmanagementsystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.farmmanagementsystem.dto.FieldDto;
import com.example.farmmanagementsystem.service.FieldService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/field")
@RequiredArgsConstructor
public class FieldController {

	private final FieldService fieldService;
	
	@GetMapping("/{id}")
	public FieldDto getCropById(@PathVariable("id") Long fieldId) {
		return fieldService.getFieldById(fieldId);
	}
	
	@GetMapping()
	public List<FieldDto> getAllCrop(){
		return fieldService.getAllFields();
	}
	
	@GetMapping("/crops")
	public List<FieldDto> getAllFieldWithCrops(){
		return fieldService.getAllFieldsWithCrops();
	}
	
	@PostMapping("/farm/{farmId}")
	public FieldDto saveCrop(@PathVariable(value = "farmId") Long farmId,
							@RequestBody FieldDto fieldDto) {
		return fieldService.saveField(farmId, fieldDto);
	}
	
	@PutMapping("/{id}")
	public FieldDto updateCrop(@PathVariable("id") Long fieldId
							, @RequestBody FieldDto fieldDto) {
		return fieldService.updateField(fieldId, fieldDto);
	}
	
	@DeleteMapping("/{id}")
	public String deleteCrop(@PathVariable("id") Long fieldId) {
		fieldService.deleteField(fieldId);
		return "Farm Deleted Successfully...";
	}
}
