package com.feirasoft.postservice.service;

import com.feirasoft.postservice.model.Category;

import java.util.Collection;

public interface PostCategoryService {
    Collection<Category> retrieveCategories();
    void createCategory(Category category);
    void updateCategory(Integer id, Category category);
    void deleteCategory(Integer id);
}
