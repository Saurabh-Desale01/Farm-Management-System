package com.example.farmmanagementsystem.service;

import java.util.List;

import com.example.farmmanagementsystem.dto.EquipmentDto;

public interface EquipmentService {

	EquipmentDto getEquipmentById(Long equipmentId);

	List<EquipmentDto> getAllEquipment();

	EquipmentDto saveEquipment(EquipmentDto equipment);

	EquipmentDto updateEquipment(Long equipmentId, EquipmentDto equipment);

	void deleteEquipment(Long equipmentId);
}
