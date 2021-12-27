package com.feirasoft.postservice.service.impl;

import com.feirasoft.postservice.model.Category;
import com.feirasoft.postservice.repository.CategoryRepository;
import com.feirasoft.postservice.service.PostCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements PostCategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Integer id, Category category) {
//        Category newCategory = categoryRepository.findById(id).get();
//        newCategory.setName(category.getName());
//        categoryRepository.save(newCategory);
    }

    @Override
    public void deleteCategory(Integer id) {
//        categoryRepository.deleteById(id);
    }
}
