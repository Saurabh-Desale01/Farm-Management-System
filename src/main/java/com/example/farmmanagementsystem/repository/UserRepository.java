package com.example.farmmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.farmmanagementsystem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
