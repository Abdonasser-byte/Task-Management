package com.ProjectDocker.Project.Controller;


import com.ProjectDocker.Project.Dto.CategoryDto;
import com.ProjectDocker.Project.Mapper.UserMapper;
import com.ProjectDocker.Project.Model.Category;
import com.ProjectDocker.Project.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // FIXME  change name ("ConvesionName")
    @PostMapping("/create")
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto) { // PassDTO FIXME
        return categoryService.saveCategory(categoryDto); //FIXME
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/user/{userId}")
    public List<CategoryDto> getCategoriesByUser(@PathVariable Long userId) {
        return categoryService.getCategoriesByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}