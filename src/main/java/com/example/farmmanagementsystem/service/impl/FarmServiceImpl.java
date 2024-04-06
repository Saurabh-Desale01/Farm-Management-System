package com.example.farmmanagementsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.farmmanagementsystem.dto.FarmDto;
import com.example.farmmanagementsystem.dto.FieldDto;
import com.example.farmmanagementsystem.model.Farm;
import com.example.farmmanagementsystem.repository.FarmRepository;
import com.example.farmmanagementsystem.service.FarmService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService{

	private final FarmRepository farmRepository;
	
	private final ModelMapper mapper;
	
	@Override
	public FarmDto getFarmById(Long farmId) {
		Farm farm = farmRepository.findById(farmId)
				.orElseThrow(()-> new EntityNotFoundException("Farm not found with ID: " + farmId));
		
		return mapToDto(farm);
	}

	@Override
	public List<FarmDto> getAllFarm() {
		List<Farm> farm = farmRepository.findAll();
		
		return farm.stream().map(this::mapToDto).collect(Collectors.toList());
	}

	@Override
	public FarmDto saveFarm(FarmDto farmDto) {
		Farm farm = mapToEntity(farmDto);
		
		Farm farmResponse = farmRepository.save(farm);
		
		return mapToDto(farmResponse);
		
	}

	@Override
	public FarmDto updateFarm(Long farmId, FarmDto farmDto) {
	    FarmDto existingFarm = getFarmById(farmId);
        // Update fields based on your requirements
        existingFarm.setName(farmDto.getName());
        existingFarm.setLocation(farmDto.getLocation());
        existingFarm.setType(farmDto.getType());
        
        Farm farm = mapToEntity(existingFarm);
        
        Farm farmResponse = farmRepository.save(farm);
        
        return mapToDto(farmResponse);
		
	}

	@Override
	public void deleteFarm(Long farmId) {
		farmRepository.deleteById(farmId);	
	}
	
	public FarmDto mapToDto(Farm farm) {
		FarmDto farmDto = mapper.map(farm, FarmDto.class);
		
//		FarmDto farmDto = FarmDto.builder()
//				//.farmId(farm.getFarmId())
//				.name(farm.getName())
//				.location(farm.getLocation())
//				.type(farm.getType())
////				.user(farm.getUser())
////				.equipment(farm.getEquipment())
////				.field(farm.getField())
////				.inventoryItem(farm.getInventoryItem())
//				.build();
		
		return farmDto;
	}
	
	public Farm mapToEntity(FarmDto farmDto) {
		Farm farm = mapper.map(farmDto, Farm.class);
		
//		Farm farm = Farm.builder()
//				//.farmId(farmDto.getFarmId())
//				.name(farmDto.getName())
//				.location(farmDto.getLocation())
//				.type(farmDto.getType())
////				.user(farmDto.getUser())
////				.equipment(farmDto.getEquipment())
////				.field(farmDto.getField())
////				.inventoryItem(farmDto.getInventoryItem())
//				.build();
		
		return farm;
	}
	
	@Override
	public List<FarmDto> getAllFarmWithfields() {
        List<Farm> farm = farmRepository.findAll();
        return farm.stream()
                     .map(this::convertToDTOWithFields)
                     .collect(Collectors.toList());
    }

    private FarmDto convertToDTOWithFields(Farm farm) {
    	   FarmDto farmDTO = mapper.map(farm, FarmDto.class);
           List<FieldDto> fieldDTOs = farm.getField().stream()
                                           .map(field -> mapper.map(field, FieldDto.class))
                                           .collect(Collectors.toList());
           farmDTO.setField(fieldDTOs);
           return farmDTO;
    }

}
