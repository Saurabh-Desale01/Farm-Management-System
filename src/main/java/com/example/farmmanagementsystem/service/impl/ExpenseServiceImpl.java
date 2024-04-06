package com.example.farmmanagementsystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.farmmanagementsystem.dto.ExpenseDto;
import com.example.farmmanagementsystem.model.Crop;
import com.example.farmmanagementsystem.model.Expense;
import com.example.farmmanagementsystem.repository.CropRepository;
import com.example.farmmanagementsystem.repository.ExpenseRepository;
import com.example.farmmanagementsystem.service.ExpenseService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

	private final ExpenseRepository expenseRepository;

	private final CropRepository cropRepository;

	private final ModelMapper mapper;

	@Override
	public ExpenseDto getExpenseById(Long expenseId) {
		Expense expense = expenseRepository.findById(expenseId)
				.orElseThrow(() -> new EntityNotFoundException("Expense not found with ID: " + expenseId));

		return mapToDto(expense);
	}

	@Override
	public List<ExpenseDto> getAllExpenses() {
		List<Expense> expense = expenseRepository.findAll();

		return expense.stream().map(this::mapToDto).collect(Collectors.toList());
	}

	@Override
	public ExpenseDto saveExpense(Long cropId, ExpenseDto expenseDto) {
		Expense expense = mapToEntity(expenseDto);

		Crop crop = cropRepository.findById(cropId)
				.orElseThrow(() -> new EntityNotFoundException("Crop not found with ID: " + cropId));

		expense.setCrop(crop);

		// field.getCrop().add(crop);

		Expense farmResponse = expenseRepository.save(expense);

		return mapToDto(farmResponse);

	}

	@Override
	public ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto) {
		ExpenseDto existingDto = getExpenseById(expenseId);
		existingDto.setDescription(expenseDto.getDescription());
		existingDto.setAmount(expenseDto.getAmount());
		existingDto.setExpenseDate(expenseDto.getExpenseDate());
		
		Expense expense = mapToEntity(existingDto);
		
		Expense cropExpense = expenseRepository.save(expense);
		
		return mapToDto(cropExpense);

	}

	@Override
	public void deleteExpense(Long expenseId) {
		expenseRepository.deleteById(expenseId);

	}

	public ExpenseDto mapToDto(Expense expense) {
		ExpenseDto expenseDto = mapper.map(expense, ExpenseDto.class);
		return expenseDto;
	}

	public Expense mapToEntity(ExpenseDto expenseDto) {
		Expense expense = mapper.map(expenseDto, Expense.class);
		return expense;
	}

}
