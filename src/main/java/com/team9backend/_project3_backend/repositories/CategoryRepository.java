package com.team9backend._project3_backend.repositories;

import com.team9backend._project3_backend.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
