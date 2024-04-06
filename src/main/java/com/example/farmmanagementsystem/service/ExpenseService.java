package com.example.farmmanagementsystem.service;

import java.util.List;

import com.example.farmmanagementsystem.dto.ExpenseDto;

public interface ExpenseService {

	ExpenseDto getExpenseById(Long expenseId);

	List<ExpenseDto> getAllExpenses();

	ExpenseDto saveExpense(Long cropId, ExpenseDto expenseDto);

	ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto);

	void deleteExpense(Long expenseId);
}
