package com.example.farmmanagementsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.farmmanagementsystem.dto.EquipmentDto;
import com.example.farmmanagementsystem.model.Equipment;
import com.example.farmmanagementsystem.repository.EquipmentRepository;
import com.example.farmmanagementsystem.service.EquipmentService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService{
	
	private final EquipmentRepository equipmentRepository;
	
	private final ModelMapper mapper;
	
	@Override
	public EquipmentDto getEquipmentById(Long equipmentId) {
		Equipment equipment = equipmentRepository.findById(equipmentId)
				.orElseThrow(() -> new EntityNotFoundException("Field not found with ID: " + equipmentId));

		return mapToDto(equipment);
	}

	@Override
	public List<EquipmentDto> getAllEquipment() {
		List<Equipment> equipment = equipmentRepository.findAll();

		List<EquipmentDto> equipmentDto = equipment.stream().map(this::mapToDto).collect(Collectors.toList());
		
		return equipmentDto;
	}

	@Override
	public EquipmentDto saveEquipment(EquipmentDto equipmentDto) {
		Equipment equipment = mapToEntity(equipmentDto);
		
		Equipment farmResponse = equipmentRepository.save(equipment);
		
		return mapToDto(farmResponse);
		
	}

	@Override
	public EquipmentDto updateEquipment(Long equipmentId, EquipmentDto equipmentDto) {
		EquipmentDto existingField = getEquipmentById(equipmentId);
        // Update fields based on your requirements
		existingField.setName(equipmentDto.getName());
		existingField.setType(equipmentDto.getType());
		existingField.setPurchaseDate(equipmentDto.getPurchaseDate());
		existingField.setMaintenanceDate(equipmentDto.getMaintenanceDate());
        
        Equipment equipment = mapToEntity(existingField);
        
        Equipment fieldResponse = equipmentRepository.save(equipment);
        
        return mapToDto(fieldResponse);
		
	}

	@Override
	public void deleteEquipment(Long equipmentId) {
		equipmentRepository.deleteById(equipmentId);
		
	}
	
	public EquipmentDto mapToDto(Equipment equipment) {
		EquipmentDto equipmentDto = mapper.map(equipment, EquipmentDto.class);
		return equipmentDto;
	}

	public Equipment mapToEntity(EquipmentDto equipmentDto) {
		Equipment equipment = mapper.map(equipmentDto, Equipment.class);
		return equipment;
	}

}
