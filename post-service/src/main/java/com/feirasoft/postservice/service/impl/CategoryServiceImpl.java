package com.feirasoft.postservice.service.impl;

import com.feirasoft.postservice.dto.CategoryDto;
import com.feirasoft.postservice.model.Category;
import com.feirasoft.postservice.repository.CategoryRepository;
import com.feirasoft.postservice.service.PostCategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements PostCategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public Collection<CategoryDto> retrieveCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = categoryRepository.findByName(categoryDto.getName());
        if(category == null) {
            category = new Category().setName(categoryDto.getName());
            return modelMapper.map(categoryRepository.save(category), CategoryDto.class);
        }
        return null;
    }

    @Override
    public CategoryDto updateCategory(String name, CategoryDto categoryDto) {
        Category category = categoryRepository.findByName(name);
        if(category != null) {
            category.setName(categoryDto.getName());
            return modelMapper.map(categoryRepository.save(category), CategoryDto.class);
        }
        return null;
    }

    @Override
    public boolean deleteCategory(String name) {
        Category category = categoryRepository.findByName(name);
        if(category != null) {
            categoryRepository.deleteById(category.getId());
            return true;
        }
        return false;
    }
}
