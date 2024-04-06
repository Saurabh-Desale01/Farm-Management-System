package com.example.farmmanagementsystem.service;

import java.util.List;

import com.example.farmmanagementsystem.dto.InventoryItemDto;

public interface InventoryItemService {

	InventoryItemDto getInventoryItemById(Long itemId);

	List<InventoryItemDto> getAllInventory();

	InventoryItemDto saveInventoryItem(InventoryItemDto item);

	InventoryItemDto updateInventoryItem(Long inventoryId, InventoryItemDto item);

	void deleteInventoryItem(Long itemId);
}
