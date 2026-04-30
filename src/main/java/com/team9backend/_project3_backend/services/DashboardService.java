package com.team9backend._project3_backend.services;

import com.team9backend._project3_backend.dto.DashboardResponseDto;
import com.team9backend._project3_backend.dto.ExpensePreviewDto;
import com.team9backend._project3_backend.dto.UserResponseDto;
import com.team9backend._project3_backend.models.Budget;
import com.team9backend._project3_backend.models.Category;
import com.team9backend._project3_backend.models.Expense;
import com.team9backend._project3_backend.models.User;
import com.team9backend._project3_backend.repositories.BudgetRepository;
import com.team9backend._project3_backend.repositories.CategoryRepository;
import com.team9backend._project3_backend.repositories.ExpenseRepository;
import com.team9backend._project3_backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DashboardService {

    private final UserRepository userRepository;
    private final ExpenseRepository expenseRepository;
    private final BudgetRepository budgetRepository;
    private final CategoryRepository categoryRepository;

    public DashboardService(UserRepository userRepository,
                            ExpenseRepository expenseRepository,
                            BudgetRepository budgetRepository,
                            CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.expenseRepository = expenseRepository;
        this.budgetRepository = budgetRepository;
        this.categoryRepository = categoryRepository;
    }

    public DashboardResponseDto getDashboard(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();

        LocalDateTime startDate = today.withDayOfMonth(1).atStartOfDay();
        LocalDateTime endDate = startDate.plusMonths(1);

        BigDecimal monthlySpent = expenseRepository.getMonthlySpent(
                user.getUserId(),
                startDate,
                endDate
        );

        BigDecimal monthlyBudget = budgetRepository
                .findByUserIdAndYearAndMonth(user.getUserId(), year, month)
                .map(Budget::getAmountLimit)
                .orElse(BigDecimal.ZERO);

        double budgetUsedPercentage = 0.0;

        if (monthlyBudget.compareTo(BigDecimal.ZERO) > 0) {
            budgetUsedPercentage = monthlySpent
                    .divide(monthlyBudget, 4, RoundingMode.HALF_UP)
                    .multiply(BigDecimal.valueOf(100))
                    .doubleValue();
        }

        List<ExpensePreviewDto> recentExpenses = expenseRepository
                .findRecentExpensesByUserId(user.getUserId())
                .stream()
                .map(this::toExpensePreviewDto)
                .toList();

        UserResponseDto userDto = new UserResponseDto(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getDisplayName(),
                user.getProfilePictureUrl(),
                user.getRole(),
                user.getIsActive()
        );

        return new DashboardResponseDto(
                userDto,
                monthlyBudget,
                monthlySpent,
                budgetUsedPercentage,
                recentExpenses
        );
    }

    private ExpensePreviewDto toExpensePreviewDto(Expense expense) {
        String categoryName = categoryRepository
                .findById(expense.getCategoryId())
                .map(Category::getName)
                .orElse("Unknown");

        return new ExpensePreviewDto(
                expense.getExpenseId(),
                expense.getCategoryId(),
                categoryName,
                expense.getAmount(),
                expense.getMerchantName(),
                expense.getDescription(),
                expense.getExpenseDate().toLocalDateTime()
        );
    }
}