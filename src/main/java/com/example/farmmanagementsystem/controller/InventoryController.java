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

import com.example.farmmanagementsystem.dto.InventoryItemDto;
import com.example.farmmanagementsystem.service.InventoryItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

	private final InventoryItemService inventoryService;
	
	@GetMapping("/{id}")
	public InventoryItemDto getFarmById(@PathVariable("id") Long equipmentId) {
		return inventoryService.getInventoryItemById(equipmentId);
	}
	
	@GetMapping()
	public List<InventoryItemDto> getAllFarm(){
		return inventoryService.getAllInventory();
	}
	
	@PostMapping
	public InventoryItemDto saveFarm(@RequestBody InventoryItemDto itemDto) {
		return inventoryService.saveInventoryItem(itemDto);
	}
	
	@PutMapping("/{id}")
	public InventoryItemDto updateFarm(@PathVariable("id") Long itemId
							, @RequestBody InventoryItemDto itemDto) {
		return inventoryService.updateInventoryItem(itemId, itemDto);
	}
	
	@DeleteMapping("/{id}")
	public String deleteFarm(@PathVariable("id") Long itemId) {
		inventoryService.deleteInventoryItem(itemId);
		return "Farm Deleted Successfully...";
	}
}
