package com.taskmanagement.testing.JpaTests;

import com.taskmanagement.model.UserEntity;
import com.taskmanagement.model.CategoryEntity;
import com.taskmanagement.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void testFindByUserId() {
        UserEntity user = new UserEntity(null, "username", "password", "email@example.com", null, null);
        CategoryEntity category1 = new CategoryEntity(null, "Category 1", null, user);
        CategoryEntity category2 = new CategoryEntity(null, "Category 2", null, user);
        categoryRepository.save(category1);
        categoryRepository.save(category2);

        List<CategoryEntity> categories = categoryRepository.findByUserId(user.getId());
        assertEquals(2, categories.size());
    }
}