package com.team9backend._project3_backend.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name = "currency_code", length = 3)
    private String currencyCode = "USD"; // Defaulting to USD

    @Column(name = "merchant_name")
    private String merchantName;

    private String description;

    @Column(name = "expense_date")
    private LocalDateTime expenseDate;

    @Column(name = "payment_method")
    private String paymentMethod;

    private String notes;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    // Default Constructor
    public Expense() {}

    // Standard Getters and Setters
    public Long getExpenseId() { return expenseId; }
    public void setExpenseId(Long expenseId) { this.expenseId = expenseId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }
    public BigDecimal  getAmount() { return amount; }
    public void setAmount(BigDecimal  amount) { this.amount = amount; }
    public String getCurrencyCode() { return currencyCode; }
    public void setCurrencyCode(String currencyCode) { this.currencyCode = currencyCode; }
    public String getMerchantName() { return merchantName; }
    public void setMerchantName(String merchantName) { this.merchantName = merchantName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getExpenseDate() { return expenseDate; }
    public void setExpenseDate(LocalDateTime expenseDate) { this.expenseDate = expenseDate; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
