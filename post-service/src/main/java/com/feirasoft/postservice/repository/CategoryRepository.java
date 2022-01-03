package com.feirasoft.postservice.repository;

import com.feirasoft.postservice.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
    Category findByName(String name);
}
