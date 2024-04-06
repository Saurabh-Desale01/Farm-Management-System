package com.example.farmmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.farmmanagementsystem.model.InventoryItem;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long>{

}
