package com.example.farmmanagementsystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.farmmanagementsystem.dto.ExpenseDto;
import com.example.farmmanagementsystem.service.ExpenseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
public class ExpenseController {

	private final ExpenseService expenseService;

	@GetMapping("/{id}")
	public ExpenseDto getExpenseById(@PathVariable("id") Long cropId) {
		return expenseService.getExpenseById(cropId);
	}

	@GetMapping()
	public List<ExpenseDto> getAllExpenses() {
		return expenseService.getAllExpenses();
	}

	@PostMapping("/crop/{cropId}/expense")
	public ExpenseDto saveExpense(@PathVariable(value = "cropId") Long cropId, @RequestBody ExpenseDto expenseDto) {
		return expenseService.saveExpense(cropId, expenseDto);
	}

	@PutMapping("/{id}")
	public ExpenseDto updateExpense(@PathVariable("id") Long expenseId, @RequestBody ExpenseDto expenseDto) {
		return expenseService.updateExpense(expenseId, expenseDto);
	}

	@DeleteMapping("/{id}")
	public String deleteExpense(@PathVariable("id") Long cropId) {
		expenseService.deleteExpense(cropId);
		return "Farm Deleted Successfully...";
	}
}
