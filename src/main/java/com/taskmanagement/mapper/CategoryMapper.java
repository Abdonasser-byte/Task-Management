package com.taskmanagement.mapper;

import com.taskmanagement.dto.CategoryDto;
import com.taskmanagement.model.CategoryEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class CategoryMapper {

    public static CategoryDto toDto(CategoryEntity categoryEntity) {
        return CategoryDto.builder()
                .id(categoryEntity.getId())
                .title(categoryEntity.getTitle())
                .tasks(categoryEntity.getTasks().stream()
                        .map(TaskMapper::toDto)
                        .collect(Collectors.toList()))
                .user(UserMapper.toResponseDto(categoryEntity.getUser()))
                .build();
    }

    public static CategoryEntity toEntity(CategoryDto categoryDto) {
        return CategoryEntity.builder()
                .id(categoryDto.getId())
                .title(categoryDto.getTitle())
                .tasks(categoryDto.getTasks() != null ? categoryDto.getTasks().stream()
                        .map(TaskMapper::toEntity)
                        .collect(Collectors.toList()) : null)
                .user(UserMapper.toEntityFromResponse(categoryDto.getUser()))  // Corrected usage
                .build();
    }
}