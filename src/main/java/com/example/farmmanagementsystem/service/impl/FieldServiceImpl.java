package com.example.farmmanagementsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.farmmanagementsystem.dto.CropDto;
import com.example.farmmanagementsystem.dto.FieldDto;
import com.example.farmmanagementsystem.model.Farm;
import com.example.farmmanagementsystem.model.Field;
import com.example.farmmanagementsystem.repository.FarmRepository;
import com.example.farmmanagementsystem.repository.FieldRepository;
import com.example.farmmanagementsystem.service.FieldService;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FieldServiceImpl implements FieldService {

	private final FieldRepository fieldRepository;
	
	private final FarmRepository farmRepository;
	
	private final ModelMapper mapper;

	@Override
	public FieldDto getFieldById(Long fieldId) {
		Field field = fieldRepository.findById(fieldId)
				.orElseThrow(() -> new EntityNotFoundException("Field not found with ID: " + fieldId));

		return mapToDto(field);
	}

	@Override
	public List<FieldDto> getAllFields() {
		List<Field> field = fieldRepository.findAll();

		List<FieldDto> fieldDto = field.stream().map(this::mapToDto).collect(Collectors.toList());
		
		return fieldDto;
	
	}

	@Override
	public FieldDto saveField(Long farmId, FieldDto fieldDto) {
		Field field = mapToEntity(fieldDto);
		
		Farm farm = farmRepository.findById(farmId).orElseThrow(
				()-> new EntityNotFoundException("Farm not found with ID: " + farmId));

		field.setFarm(farm);;
		
		//field.getCrop().add(crop);
		
		Field farmResponse = fieldRepository.save(field);

		return mapToDto(farmResponse);

	}

	@Override
	public FieldDto updateField(Long fieldId, FieldDto fieldDto) {
		FieldDto existingField = getFieldById(fieldId);
        // Update fields based on your requirements
		existingField.setName(fieldDto.getName());
		existingField.setSize(fieldDto.getSize());
        
        Field field = mapToEntity(existingField);
        
        Field fieldResponse = fieldRepository.save(field);
        
        return mapToDto(fieldResponse);

	}

	@Override
	public void deleteField(Long fieldId) {
		fieldRepository.deleteById(fieldId);

	}

	public FieldDto mapToDto(Field field) {
		FieldDto fieldDto = mapper.map(field, FieldDto.class);
		
//		FieldDto fieldDto = FieldDto.builder()
//				.fieldId(field.getFieldId())
//				.name(field.getName())
//				.size(field.getSize())
//				//.crop(field.getCrop())
//				.build();

		return fieldDto;
	}

	public Field mapToEntity(FieldDto fieldDto) {
		Field field = mapper.map(fieldDto, Field.class);
		
//		Field field = Field.builder()
//				.fieldId(fieldDto.getFieldId())
//				.name(fieldDto.getName())
//				.size(fieldDto.getSize())
//				//.crop(fieldDto.getCrop())
//				.build();

		return field;
	}
	
	@Override
	public List<FieldDto> getAllFieldsWithCrops() {
        List<Field> fields = fieldRepository.findAll();
        return fields.stream()
                     .map(this::convertToDTOWithCrops)
                     .collect(Collectors.toList());
    }

    private FieldDto convertToDTOWithCrops(Field field) {
    	   FieldDto fieldDTO = mapper.map(field, FieldDto.class);
           List<CropDto> cropDTOs = field.getCrop().stream()
                                           .map(crop -> mapper.map(crop, CropDto.class))
                                           .collect(Collectors.toList());
           fieldDTO.setCrop(cropDTOs);
           return fieldDTO;
    }
    
//    private CropDto convertCropToDTO(Crop crop) {
//        CropDto cropDTO = new CropDto();
//        BeanUtils.copyProperties(crop, cropDTO);
//        return cropDTO;
//    }

}
