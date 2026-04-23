package com.team9backend._project3_backend.repositories;

import com.team9backend._project3_backend.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // This  method allows to fetch all expenses for a specific user
    List<Expense> findByUserId(Long userId);
}