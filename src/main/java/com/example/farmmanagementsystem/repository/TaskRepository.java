package com.example.farmmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.farmmanagementsystem.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}
