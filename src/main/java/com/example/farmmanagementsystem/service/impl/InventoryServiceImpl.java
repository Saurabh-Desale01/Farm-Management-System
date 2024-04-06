package com.example.farmmanagementsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.farmmanagementsystem.dto.InventoryItemDto;
import com.example.farmmanagementsystem.model.InventoryItem;
import com.example.farmmanagementsystem.repository.InventoryItemRepository;
import com.example.farmmanagementsystem.service.InventoryItemService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryItemService{
	
	private final InventoryItemRepository inventoryRepository;
	
	private final ModelMapper mapper;
	
	@Override
	public InventoryItemDto getInventoryItemById(Long itemId) {
		InventoryItem inventory = inventoryRepository.findById(itemId)
				.orElseThrow(() -> new EntityNotFoundException("Inventory not found with ID: " + itemId));

		return mapToDto(inventory);
	}

	@Override
	public List<InventoryItemDto> getAllInventory() {
		List<InventoryItem> inventory = inventoryRepository.findAll();

		List<InventoryItemDto> inventoryDto = inventory.stream().map(this::mapToDto).collect(Collectors.toList());
		
		return inventoryDto;
	}

	@Override
	public InventoryItemDto saveInventoryItem(InventoryItemDto itemDto) {
		InventoryItem inventory = mapToEntity(itemDto);
		
		InventoryItem farmResponse = inventoryRepository.save(inventory);
		
		return mapToDto(farmResponse);
		
	}

	@Override
	public InventoryItemDto updateInventoryItem(Long inventoryId, InventoryItemDto itemDto) {
		InventoryItemDto existingInventory = getInventoryItemById(inventoryId);
        // Update fields based on your requirements
		existingInventory.setName(itemDto.getName());
		existingInventory.setQuantity(itemDto.getQuantity());
		existingInventory.setUnitPrice(itemDto.getUnitPrice());
		existingInventory.setPurchaseDate(itemDto.getPurchaseDate());
		
        
        InventoryItem inventory = mapToEntity(existingInventory);
        
        InventoryItem inventoryResponse = inventoryRepository.save(inventory);
        
        return mapToDto(inventoryResponse);
		
	}

	@Override
	public void deleteInventoryItem(Long itemId) {
		inventoryRepository.deleteById(itemId);
		
	}
	
	public InventoryItemDto mapToDto(InventoryItem inventory) {
		InventoryItemDto inventoryDto = mapper.map(inventory, InventoryItemDto.class);
		return inventoryDto;
	}

	public InventoryItem mapToEntity(InventoryItemDto inventoryDto) {
		InventoryItem inventory = mapper.map(inventoryDto, InventoryItem.class);
		return inventory;
	}



}
