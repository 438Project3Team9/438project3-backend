package com.team9backend._project3_backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "name", nullable = false)
    private String name;

    public Category() {}

    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }
}