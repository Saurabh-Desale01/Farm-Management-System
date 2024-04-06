package com.example.farmmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.farmmanagementsystem.model.Crop;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long>{

}
