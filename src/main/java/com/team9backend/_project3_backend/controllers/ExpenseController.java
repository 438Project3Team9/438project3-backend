package com.team9backend._project3_backend.controllers;

import com.team9backend._project3_backend.models.Expense;
import com.team9backend._project3_backend.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> getAll() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/user/{userId}")
    public List<Expense> getByUserId(@PathVariable Long userId) {
        return expenseService.getExpensesByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<Expense> create(@RequestBody Expense expense) {
        return ResponseEntity.ok(expenseService.saveExpense(expense));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> update(@PathVariable Long id, @RequestBody Expense expenseDetails) {
        return expenseService.getExpenseById(id)
                .map(existingExpense -> {
                    existingExpense.setAmount(expenseDetails.getAmount());
                    existingExpense.setMerchantName(expenseDetails.getMerchantName());
                    existingExpense.setDescription(expenseDetails.getDescription());
                    existingExpense.setExpenseDate(expenseDetails.getExpenseDate());
                    existingExpense.setCategoryId(expenseDetails.getCategoryId());
                    existingExpense.setNotes(expenseDetails.getNotes());

                    Expense updatedExpense = expenseService.saveExpense(existingExpense);
                    return ResponseEntity.ok(updatedExpense);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build(); // Returns 204 No Content
    }
}