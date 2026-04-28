package com.team9backend._project3_backend.repositories;

import com.team9backend._project3_backend.models.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    Optional<Budget> findByUser_UserIdAndYearAndMonth(Long userId, Integer year, Integer month);
}
