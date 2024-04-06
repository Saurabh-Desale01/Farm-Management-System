package com.example.farmmanagementsystem.service;

import java.util.List;

import com.example.farmmanagementsystem.dto.FarmDto;

public interface FarmService {

	FarmDto getFarmById(Long farmId);

	List<FarmDto> getAllFarm();

	FarmDto saveFarm(FarmDto farm);

	FarmDto updateFarm(Long farmId, FarmDto farmDto);

	void deleteFarm(Long farmId);
	
	List<FarmDto> getAllFarmWithfields();
}
