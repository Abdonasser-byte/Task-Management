package com.taskmanagement.services;


import com.taskmanagement.dto.TaskDto;
import com.taskmanagement.mapper.TaskMapper;
import com.taskmanagement.model.TaskEntity;
import com.taskmanagement.repositories.TaskRepository;
import com.taskmanagement.exceptions.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Create or update a task
    public TaskDto saveTask(TaskDto taskDto) {
        TaskEntity taskEntity = TaskMapper.toEntity(taskDto);
        TaskEntity savedTask = taskRepository.save(taskEntity);
        return TaskMapper.toDto(savedTask);
    }

    // Get task by ID
    public TaskDto getTaskById(Long id) {
        return taskRepository.findById(id)
                .map(TaskMapper::toDto)
                .orElseThrow(() -> new TaskNotFoundException("No tasks found : "));
    }

    // Get tasks by user ID
    public List<TaskDto> getTasksByUserId(Long userId) {
        List<TaskEntity> tasks = taskRepository.findByUserId(userId);

        if (tasks.isEmpty()) {
            throw new TaskNotFoundException("No tasks found for user ID: " + userId);
        }

        return tasks.stream()
                .map(TaskMapper::toDto)
                .collect(Collectors.toList());

    }

    // Delete task by ID
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw  new TaskNotFoundException("No thasks Here");
        }
        taskRepository.deleteById(id);
    }
}