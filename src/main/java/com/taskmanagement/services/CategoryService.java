package com.taskmanagement.services;


import com.taskmanagement.dto.CategoryDto;
import com.taskmanagement.mapper.CategoryMapper;
import com.taskmanagement.model.CategoryEntity;
import com.taskmanagement.repositories.CategoryRepository;
import com.taskmanagement.exceptions.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
    }

    // Create or update a category
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        CategoryEntity categoryEntity = CategoryMapper.toEntity(categoryDto);
        CategoryDto savedCategory = CategoryMapper.toDto(categoryRepository.save(categoryEntity));
        return savedCategory;
    }

    // Get category by ID
    public CategoryDto getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper::toDto)
                .orElseThrow(() -> new CategoryNotFoundException("We can't find any Categories"));
    }

    // Get categories by user ID
    public List<CategoryDto> getCategoriesByUserId(Long userId) {
        List<CategoryDto> categoryDtos = categoryRepository.findByUserId(userId).stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());

        if(categoryDtos.isEmpty()){
            throw new CategoryNotFoundException("We can't find it");
        }
        return categoryDtos;
    }

    // Delete category by ID
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new CategoryNotFoundException("We can't find it");
        }
        categoryRepository.deleteById(id);
    }
}