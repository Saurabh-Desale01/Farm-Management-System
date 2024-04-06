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

import com.example.farmmanagementsystem.dto.EquipmentDto;
import com.example.farmmanagementsystem.service.EquipmentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/equipment")
@RequiredArgsConstructor
public class EquipmentController {

	private final EquipmentService equipmentService;
	
	@GetMapping("/{id}")
	public EquipmentDto getFarmById(@PathVariable("id") Long equipmentId) {
		return equipmentService.getEquipmentById(equipmentId);
	}
	
	@GetMapping()
	public List<EquipmentDto> getAllFarm(){
		return equipmentService.getAllEquipment();
	}
	
	@PostMapping
	public EquipmentDto saveFarm(@RequestBody EquipmentDto equipmentDto) {
		return equipmentService.saveEquipment(equipmentDto);
	}
	
	@PutMapping("/{id}")
	public EquipmentDto updateFarm(@PathVariable("id") Long equipmentId
							, @RequestBody EquipmentDto equipmentDto) {
		return equipmentService.updateEquipment(equipmentId, equipmentDto);
	}
	
	@DeleteMapping("/{id}")
	public String deleteFarm(@PathVariable("id") Long equipmentId) {
		equipmentService.deleteEquipment(equipmentId);
		return "Farm Deleted Successfully...";
	}
}
