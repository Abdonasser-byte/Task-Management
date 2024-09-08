package com.taskmanagement.testing.ServicesTests;
/*
import com.ProjectDocker.Project.Dto.CategoryDto;
import com.ProjectDocker.Project.Mapper.CategoryMapper;
import com.ProjectDocker.Project.Model.CategoryEntity;
import com.ProjectDocker.Project.Repositories.CategoryRepository;
import com.ProjectDocker.Project.Services.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCategory() {
        CategoryDto categoryDto = new CategoryDto(1L, "Category Title", null, null);
        CategoryEntity categoryEntity = new CategoryEntity(1L, "Category Title", null, null);

        when(CategoryMapper.toEntity(any(CategoryDto.class))).thenReturn(categoryEntity);
        when(categoryRepository.save(any(CategoryEntity.class))).thenReturn(categoryEntity);
        when(CategoryMapper.toDto(any(CategoryEntity.class))).thenReturn(categoryDto);

        CategoryDto savedCategory = categoryService.saveCategory(categoryDto).getBody();

        assertEquals(categoryDto, savedCategory);
        verify(categoryRepository, times(1)).save(any(CategoryEntity.class));
    }

    @Test
    void testGetCategoryById() {
        Long categoryId = 1L;
        CategoryEntity categoryEntity = new CategoryEntity(categoryId, "Category Title", null, null);
        CategoryDto categoryDto = new CategoryDto(categoryId, "Category Title", null, null);

        when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(categoryEntity));
        when(CategoryMapper.toDto(any(CategoryEntity.class))).thenReturn(categoryDto);

        ResponseEntity<CategoryDto> response = categoryService.getCategoryById(categoryId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(categoryDto, response.getBody());
        verify(categoryRepository, times(1)).findById(categoryId);
    }

    @Test
    void testGetCategoriesByUserId() {
        Long userId = 1L;
        List<CategoryEntity> categoryEntities = Arrays.asList(
                new CategoryEntity(1L, "Category 1", null, null),
                new CategoryEntity(2L, "Category 2", null, null)
        );
        List<CategoryDto> categoryDtos = Arrays.asList(
                new CategoryDto(1L, "Category 1", null, null),
                new CategoryDto(2L, "Category 2", null, null)
        );

        when(categoryRepository.findByUserId(userId)).thenReturn(categoryEntities);
        when(CategoryMapper.toDto(any(CategoryEntity.class))).thenReturn(categoryDtos.get(0), categoryDtos.get(1));

        ResponseEntity<List<CategoryDto>> response = categoryService.getCategoriesByUserId(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(categoryDtos, response.getBody());
        verify(categoryRepository, times(1)).findByUserId(userId);
    }

    @Test
    void testDeleteCategory() {
        Long categoryId = 1L;

        when(categoryRepository.existsById(categoryId)).thenReturn(true);
        doNothing().when(categoryRepository).deleteById(categoryId);

        ResponseEntity<Void> response = categoryService.deleteCategory(categoryId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(categoryRepository, times(1)).deleteById(categoryId);
    }
}
*/