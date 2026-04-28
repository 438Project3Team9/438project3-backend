package com.team9backend._project3_backend.dto;

import java.math.BigDecimal;
import java.util.List;

public class DashboardResponseDto {

    private UserResponseDto user;
    private BigDecimal monthlyBudget;
    private BigDecimal monthlySpent;
    private double budgetUsedPercentage;
    private List<ExpensePreviewDto> recentExpenses;

    public DashboardResponseDto(UserResponseDto user,
                                BigDecimal monthlyBudget,
                                BigDecimal monthlySpent,
                                double budgetUsedPercentage,
                                List<ExpensePreviewDto> recentExpenses) {
        this.user = user;
        this.monthlyBudget = monthlyBudget;
        this.monthlySpent = monthlySpent;
        this.budgetUsedPercentage = budgetUsedPercentage;
        this.recentExpenses = recentExpenses;
    }

    public UserResponseDto getUser() { return user; }
    public BigDecimal getMonthlyBudget() { return monthlyBudget; }
    public BigDecimal getMonthlySpent() { return monthlySpent; }
    public double getBudgetUsedPercentage() { return budgetUsedPercentage; }
    public List<ExpensePreviewDto> getRecentExpenses() { return recentExpenses; }
}
