package com.example.farmmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.farmmanagementsystem.model.Equipment;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long>{

}
