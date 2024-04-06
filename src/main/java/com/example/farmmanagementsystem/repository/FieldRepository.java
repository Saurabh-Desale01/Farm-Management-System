package com.example.farmmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.farmmanagementsystem.model.Field;

@Repository
public interface FieldRepository extends JpaRepository<Field, Long>{

}
