package com.team9backend._project3_backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExpensePreviewDto {

    private Long expenseId;
    private Long categoryId;
    private String categoryName;
    private BigDecimal amount;
    private String merchantName;
    private String description;
    private LocalDateTime expenseDate;

    public ExpensePreviewDto(Long expenseId, Long categoryId, String categoryName,
                             BigDecimal amount, String merchantName,
                             String description, LocalDateTime expenseDate) {
        this.expenseId = expenseId;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.amount = amount;
        this.merchantName = merchantName;
        this.description = description;
        this.expenseDate = expenseDate;
    }

    public Long getExpenseId() { return expenseId; }
    public Long getCategoryId() { return categoryId; }
    public String getCategoryName() { return categoryName; }
    public BigDecimal getAmount() { return amount; }
    public String getMerchantName() { return merchantName; }
    public String getDescription() { return description; }
    public LocalDateTime getExpenseDate() { return expenseDate; }
}