package com.team9backend._project3_backend.repositories;

import com.team9backend._project3_backend.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // This  method allows to fetch all expenses for a specific user
    List<Expense> findByUserId(Long userId);

    List<Expense> findRecentExpensesByUserId(Long userId);

    @Query("""
           SELECT COALESCE(SUM(e.amount), 0)
           FROM Expense e
           WHERE e.userId = :userId
           AND e.expenseDate >= :startDate
           AND e.expenseDate < :endDate
           """)
    BigDecimal getMonthlySpent(Long userId, LocalDateTime startDate, LocalDateTime endDate);
}