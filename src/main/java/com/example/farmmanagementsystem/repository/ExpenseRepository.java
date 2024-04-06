package com.example.farmmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.farmmanagementsystem.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

}
