package com.team9backend._project3_backend.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "budgets")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "budget_id")
    private Long budgetId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int category_id;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer month;

    @Column(name = "amount_limit", nullable = false)
    private BigDecimal amountLimit;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    public Budget() {}

    public Long getBudgetId() { return budgetId; }
    public Long getUserId() { return userId; }
    public Integer getYear() { return year; }
    public Integer getMonth() { return month; }
    public BigDecimal getAmountLimit() { return amountLimit; }
}