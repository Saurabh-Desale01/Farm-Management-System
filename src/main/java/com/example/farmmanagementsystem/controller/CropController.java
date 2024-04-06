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

import com.example.farmmanagementsystem.dto.CropDto;
import com.example.farmmanagementsystem.service.CropService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CropController {

	private final CropService cropService;
	
	@GetMapping("/{id}")
	public CropDto getCropById(@PathVariable("id") Long cropId) {
		return cropService.getCropById(cropId);
	}
	
	@GetMapping()
	public List<CropDto> getAllCrop(){
		return cropService.getAllCrops();
	}
	
	@GetMapping("/expenses")
	public List<CropDto> getAllFieldWithExpenses(){
		return cropService.getAllCropsWithExpense();
	}
	
	@PostMapping("/field/{fieldId}/crop")
	public CropDto saveCrop(@PathVariable(value = "fieldId") long fieldId, 
							@RequestBody CropDto cropDto) {
		return cropService.saveCrop(fieldId, cropDto);
	}
	
	@PutMapping("/{id}")
	public CropDto updateCrop(@PathVariable("id") Long cropId
							, @RequestBody CropDto cropDto) {
		return cropService.updateCrop(cropId, cropDto);
	}
	
	@DeleteMapping("/{id}")
	public String deleteCrop(@PathVariable("id") Long cropId) {
		cropService.deleteCrop(cropId);
		return "Farm Deleted Successfully...";
	}
}
