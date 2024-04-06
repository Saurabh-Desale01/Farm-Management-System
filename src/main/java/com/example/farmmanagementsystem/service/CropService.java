package com.example.farmmanagementsystem.service;

import java.util.List;

import com.example.farmmanagementsystem.dto.CropDto;

public interface CropService {

	CropDto getCropById(Long cropId);

	List<CropDto> getAllCrops();

	CropDto saveCrop(long fieldId, CropDto crop);

	CropDto updateCrop(Long cropId, CropDto crop);

	void deleteCrop(Long cropId);
	
	List<CropDto> getAllCropsWithExpense();
}
