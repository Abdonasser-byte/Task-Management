package com.ProjectDocker.Project.Services;


import com.ProjectDocker.Project.Dto.CategoryDto;
import com.ProjectDocker.Project.Mapper.CategoryMapper;
import com.ProjectDocker.Project.Model.Category;
import com.ProjectDocker.Project.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDto saveCategory(CategoryDto categoryDto) {
        return CategoryMapper.toDto(categoryRepository.save(CategoryMapper.toEntity(categoryDto)));
    }

    public ResponseEntity<CategoryDto> getCategoryById(Long id) {
        return (categoryRepository.findById(id)).map(category -> ResponseEntity.ok(CategoryMapper.toDto(category)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());


    }

    public List<CategoryDto> getCategoriesByUserId(Long userId) {
        List<Category> listCategory =categoryRepository.findAll();
        List<CategoryDto> listCategoryDto = new ArrayList<>();;
        for (Category category: listCategory){
            listCategoryDto.add(CategoryMapper.toDto(category));
        }
        return listCategoryDto;

    }



    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}