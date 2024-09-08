package com.taskmanagement.testing.ControllerTests;
/*
import com.ProjectDocker.Project.Controller.CategoryController;
import com.ProjectDocker.Project.Dto.CategoryDto;
import com.ProjectDocker.Project.Services.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CategoryController.class)
class CategoryControllerTest {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @MockBean
    private CategoryService categoryService;

    public CategoryControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateOrUpdateCategory() throws Exception {
        CategoryDto categoryDto = new CategoryDto(1L, "Category Title", null, null);

        when(categoryService.saveCategory(any(CategoryDto.class)))
                .thenReturn(new ResponseEntity<>(categoryDto, HttpStatus.CREATED));

        mockMvc.perform(post("/api/v1/categories")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(categoryDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Category Title"));

        verify(categoryService, times(1)).saveCategory(any(CategoryDto.class));
    }

    @Test
    void testGetCategoryById() throws Exception {
        Long categoryId = 1L;
        CategoryDto categoryDto = new CategoryDto(categoryId, "Category Title", null, null);

        when(categoryService.getCategoryById(categoryId))
                .thenReturn(new ResponseEntity<>(categoryDto, HttpStatus.OK));

        mockMvc.perform(get("/api/v1/categories/{id}", categoryId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(categoryId))
                .andExpect(jsonPath("$.title").value("Category Title"));

        verify(categoryService, times(1)).getCategoryById(categoryId);
    }

    @Test
    void testGetCategoriesByUserId() throws Exception {
        Long userId = 1L;
        List<CategoryDto> categories = Arrays.asList(
                new CategoryDto(1L, "Category 1", null, null),
                new CategoryDto(2L, "Category 2", null, null)
        );

        when(categoryService.getCategoriesByUserId(userId))
                .thenReturn(new ResponseEntity<>(categories, HttpStatus.OK));

        mockMvc.perform(get("/api/v1/categories/user/{userId}", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].title").value("Category 1"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].title").value("Category 2"));

        verify(categoryService, times(1)).getCategoriesByUserId(userId);
    }

    @Test
    void testDeleteCategory() throws Exception {
        Long categoryId = 1L;

        when(categoryService.deleteCategory(categoryId)).thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));

        mockMvc.perform(delete("/api/v1/categories/{id}", categoryId))
                .andExpect(status().isNoContent());

        verify(categoryService, times(1)).deleteCategory(categoryId);
    }
}*/