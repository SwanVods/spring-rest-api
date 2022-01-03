package com.feirasoft.postservice.service;

import com.feirasoft.postservice.dto.CategoryDto;

import java.util.Collection;

public interface PostCategoryService {
    Collection<CategoryDto> retrieveCategories();
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(String id, CategoryDto categoryDto);
    boolean deleteCategory(String name);
}
