package com.taskmanagement.controller;

import com.taskmanagement.dto.CategoryDto;
import com.taskmanagement.services.JwtValidationService;
import com.taskmanagement.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final JwtValidationService jwtValidationService;

    public CategoryController(CategoryService categoryService, JwtValidationService jwtValidationService) {
        this.categoryService = categoryService;
        this.jwtValidationService = jwtValidationService;
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createOrUpdateCategory(@RequestHeader("Authorization") String authorizationHeader,
                                                              @RequestBody CategoryDto categoryDto) {
        jwtValidationService.validateJwtAndExtractUser(authorizationHeader);  // Validate JWT
        CategoryDto savedCategory = categoryService.saveCategory(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@RequestHeader("Authorization") String authorizationHeader,
                                                       @PathVariable Long id) {
        jwtValidationService.validateJwtAndExtractUser(authorizationHeader);  // Validate JWT
        CategoryDto category = categoryService.getCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CategoryDto>> getCategoriesByUserId(@RequestHeader("Authorization") String authorizationHeader,
                                                                   @PathVariable Long userId) {
        jwtValidationService.validateJwtAndExtractUser(authorizationHeader);  // Validate JWT
        List<CategoryDto> categories = categoryService.getCategoriesByUserId(userId);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@RequestHeader("Authorization") String authorizationHeader,
                                               @PathVariable Long id) {
        jwtValidationService.validateJwtAndExtractUser(authorizationHeader);  // Validate JWT
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
