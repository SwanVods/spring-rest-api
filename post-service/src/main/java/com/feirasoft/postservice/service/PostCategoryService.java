package com.feirasoft.postservice.service;

import com.feirasoft.postservice.model.post.Category;

public interface PostCategoryService {
    void createCategory(Category category);
    void updateCategory(Integer id, Category category);
    void deleteCategory(Integer id);
}
