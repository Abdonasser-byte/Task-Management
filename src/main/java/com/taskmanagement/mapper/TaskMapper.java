package com.taskmanagement.mapper;

import com.taskmanagement.dto.TaskDto;
import com.taskmanagement.model.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public static TaskDto toDto(TaskEntity taskEntity) {
        return TaskDto.builder()
                .id(taskEntity.getId())
                .title(taskEntity.getTitle())
                .description(taskEntity.getDescription())
                .status(taskEntity.getStatus())
                .startDate(taskEntity.getStartDate())
                .endDate(taskEntity.getEndDate())
                .category(CategoryMapper.toDto(taskEntity.getCategory()))
                .build();
    }

    public static TaskEntity toEntity(TaskDto taskDto) {
        return TaskEntity.builder()
                .id(taskDto.getId())
                .title(taskDto.getTitle())
                .description(taskDto.getDescription())
                .status(taskDto.getStatus())
                .startDate(taskDto.getStartDate())
                .endDate(taskDto.getEndDate())
                .category(CategoryMapper.toEntity(taskDto.getCategory()))
                .build();
    }
}