package com.taskmanagement.mapper;

import com.taskmanagement.dto.UserRequestDto;
import com.taskmanagement.dto.UserResponseDto;

import com.taskmanagement.model.UserEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

// Use map struct
@Component
public class UserMapper {

    public static UserResponseDto toResponseDto(UserEntity userEntity) {
        return UserResponseDto.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .tasks(userEntity.getTasks().stream()
                        .map(TaskMapper::toDto)
                        .collect(Collectors.toList()))
                .categories(userEntity.getCategories().stream()
                        .map(CategoryMapper::toDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public static UserEntity toEntity(UserRequestDto userRequestDto) {
        return UserEntity.builder()
                .id(userRequestDto.getId())
                .username(userRequestDto.getUsername())
                .password(userRequestDto.getPassword())
                .email(userRequestDto.getEmail())
                .tasks(userRequestDto.getTasks() != null ? userRequestDto.getTasks().stream()
                        .map(TaskMapper::toEntity)
                        .collect(Collectors.toList()) : null)
                .categories(userRequestDto.getCategories() != null ? userRequestDto.getCategories().stream()
                        .map(CategoryMapper::toEntity)
                        .collect(Collectors.toList()) : null)
                .build();
    }

    public static UserEntity toEntityFromResponse(UserResponseDto userResponseDto) {
        return UserEntity.builder()
                .id(userResponseDto.getId())
                .username(userResponseDto.getUsername())
                .email(userResponseDto.getEmail())
                .tasks(userResponseDto.getTasks() != null ? userResponseDto.getTasks().stream()
                        .map(TaskMapper::toEntity)
                        .collect(Collectors.toList()) : null)
                .categories(userResponseDto.getCategories() != null ? userResponseDto.getCategories().stream()
                        .map(CategoryMapper::toEntity)
                        .collect(Collectors.toList()) : null)
                .build();
    }
}