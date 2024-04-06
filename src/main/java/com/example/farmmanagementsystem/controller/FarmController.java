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

import com.example.farmmanagementsystem.dto.FarmDto;
import com.example.farmmanagementsystem.service.FarmService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/farm")
@RequiredArgsConstructor
public class FarmController {

	private final FarmService farmService;
	
	@GetMapping("/{id}")
	public FarmDto getFarmById(@PathVariable("id") Long farmId) {
		return farmService.getFarmById(farmId);
	}
	
	@GetMapping()
	public List<FarmDto> getAllFarm(){
		return farmService.getAllFarm();
	}
	
	@GetMapping("/field")
	public List<FarmDto> getAllFarmWithFields(){
		return farmService.getAllFarmWithfields();
	}
	
	@PostMapping
	public FarmDto saveFarm(@RequestBody FarmDto farmDto) {
		return farmService.saveFarm(farmDto);
	}
	
	@PutMapping("/{id}")
	public FarmDto updateFarm(@PathVariable("id") Long farmId
							, @RequestBody FarmDto farmDto) {
		return farmService.updateFarm(farmId, farmDto);
	}
	
	@DeleteMapping("/{id}")
	public String deleteFarm(@PathVariable("id") Long farmId) {
		farmService.deleteFarm(farmId);
		return "Farm Deleted Successfully...";
	}
	
	
}
