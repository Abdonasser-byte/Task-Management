package com.ProjectDocker.Project.Mapper;

import com.ProjectDocker.Project.Dto.CategoryDto;
import com.ProjectDocker.Project.Dto.TaskDto;
import com.ProjectDocker.Project.Model.Category;
import com.ProjectDocker.Project.Model.Task;

public class CategoryMapper {

    public  static CategoryDto toDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setTitle(category.getTitle());
        categoryDto.setUser(category.getUser());
        categoryDto.setTasks(category.getTasks());
        return categoryDto;
    }

    public static Category toEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setTitle(categoryDto.getTitle());
        category.setUser(categoryDto.getUser());
        category.setTasks(categoryDto.getTasks());
        return category;
    }
}
