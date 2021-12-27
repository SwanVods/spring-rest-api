package com.feirasoft.postservice.repository;

import com.feirasoft.postservice.model.post.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
