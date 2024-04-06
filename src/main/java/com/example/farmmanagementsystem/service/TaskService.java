package com.example.farmmanagementsystem.service;

import java.util.List;

import com.example.farmmanagementsystem.model.Task;

public interface TaskService {

	Task getTaskById(Long taskId);

	List<Task> getTasksByFarmId(Long farmId);

	void saveTask(Task task);

	void updateTask(Task task);

	void deleteTask(Long taskId);
}
