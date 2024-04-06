package com.example.farmmanagementsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.farmmanagementsystem.dto.CropDto;
import com.example.farmmanagementsystem.dto.ExpenseDto;
import com.example.farmmanagementsystem.model.Crop;
import com.example.farmmanagementsystem.model.Field;
import com.example.farmmanagementsystem.repository.CropRepository;
import com.example.farmmanagementsystem.repository.FieldRepository;
import com.example.farmmanagementsystem.service.CropService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CropServiceImpl implements CropService {

	private final CropRepository cropRepository;
	
	private final FieldRepository fieldRepository;
	
	private final ModelMapper mapper;

	@Override
	public CropDto getCropById(Long cropId) {
		Crop crop = cropRepository.findById(cropId)
				.orElseThrow(() -> new EntityNotFoundException("Crop not found with ID: " + cropId));

		return mapToDto(crop);
	}

	@Override
	public List<CropDto> getAllCrops() {
		List<Crop> crop = cropRepository.findAll();

		return crop.stream().map(this::mapToDto).collect(Collectors.toList());
	}

	@Override
	public CropDto saveCrop(long fieldId, CropDto cropDto) {
		Crop crop = mapToEntity(cropDto);
		
		Field field = fieldRepository.findById(fieldId).orElseThrow(
				()-> new EntityNotFoundException("Field not found with ID: " + fieldId));

		crop.setField(field);
		
		//field.getCrop().add(crop);
		
		Crop farmResponse = cropRepository.save(crop);

		return mapToDto(farmResponse);
		
//		Optional<Field> optionalField = fieldRepository.findById(fieldId);
//        if (optionalField.isPresent()) {
//            Field field = optionalField.get();
//            cropDto.setField(field);
//            field.getCrops().add(crop);
//            return cropRepository.save(crop);
//        } else {
//            throw new EntityNotFoundException("Field not found with id: " + fieldId);
//        }

	}

	@Override
	public CropDto updateCrop(Long cropId, CropDto cropDto) {
		CropDto existingCrop = getCropById(cropId);
		// Update fields based on your requirements
		existingCrop.setName(cropDto.getName());
		existingCrop.setPlantingDate(cropDto.getPlantingDate());
		existingCrop.setHarvestingDate(cropDto.getHarvestingDate());
		existingCrop.setStatus(cropDto.getStatus());

		Crop crop = mapToEntity(existingCrop);

		Crop cropResponse = cropRepository.save(crop);

		return mapToDto(cropResponse);

	}

	@Override
	public void deleteCrop(Long cropId) {
		cropRepository.deleteById(cropId);

	}

	public CropDto mapToDto(Crop crop) {
		CropDto cropDto = mapper.map(crop, CropDto.class);
		
//		CropDto cropDto = CropDto.builder()
//				.cropId(crop.getCropId())
//				.name(crop.getName())
//				.plantingDate(crop.getPlantingDate())
//				.harvestingDate(crop.getHarvestingDate())
//				.status(crop.getStatus())
//				.build();

		return cropDto;
	}

	public Crop mapToEntity(CropDto cropDto) {
		Crop crop = mapper.map(cropDto, Crop.class);
		
//		Crop crop = Crop.builder()
//				.cropId(cropDto.getCropId())
//				.name(cropDto.getName())
//				.plantingDate(cropDto.getPlantingDate())
//				.harvestingDate(cropDto.getHarvestingDate())
//				.status(cropDto.getStatus())
//				.build();

		return crop;
	}

	@Override
	public List<CropDto> getAllCropsWithExpense() {
		List<Crop> crops = cropRepository.findAll();
        return crops.stream()
                     .map(this::convertToDTOWithExpenses)
                     .collect(Collectors.toList());
	}
	
    private CropDto convertToDTOWithExpenses(Crop crop) {
 	   CropDto CropDto = mapper.map(crop, CropDto.class);
        List<ExpenseDto> expenseDTOs = crop.getExpense().stream()
                                        .map(expense -> mapper.map(expense, ExpenseDto.class))
                                        .collect(Collectors.toList());
        CropDto.setExpense(expenseDTOs);
        return CropDto;
 }

}
