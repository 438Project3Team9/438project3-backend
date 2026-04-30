package com.team9backend._project3_backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "icon_name", nullable = true)
    private String icon_name;

    @Column(name = "color", nullable = true)
    private String color;

    @Column(name = "is_default", nullable = false)
    private Boolean is_default;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Category() {}

    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }
}