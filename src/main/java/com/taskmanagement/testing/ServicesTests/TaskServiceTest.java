package com.taskmanagement.testing.ServicesTests;
/*
import com.ProjectDocker.Project.Dto.TaskDto;
import com.ProjectDocker.Project.Mapper.TaskMapper;
import com.ProjectDocker.Project.Model.TaskEntity;
import com.ProjectDocker.Project.Repositories.TaskRepository;
import com.ProjectDocker.Project.Services.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveTask() {
        TaskDto taskDto = new TaskDto(1L, "Task Title", "Task Description", "OPEN", LocalDateTime.now(), LocalDateTime.now().plusDays(1), null);
        TaskEntity taskEntity = new TaskEntity(1L, "Task Title", "Task Description", "OPEN", LocalDateTime.now(), LocalDateTime.now().plusDays(1), null, null);

        when(TaskMapper.toEntity(any(TaskDto.class))).thenReturn(taskEntity);
        when(taskRepository.save(any(TaskEntity.class))).thenReturn(taskEntity);
        when(TaskMapper.toDto(any(TaskEntity.class))).thenReturn(taskDto);

        TaskDto savedTask = taskService.saveTask(taskDto).getBody();

        assertEquals(taskDto, savedTask);
        verify(taskRepository, times(1)).save(any(TaskEntity.class));
    }

    @Test
    void testGetTaskById() {
        Long taskId = 1L;
        TaskEntity taskEntity = new TaskEntity(taskId, "Task Title", "Task Description", "OPEN", LocalDateTime.now(), LocalDateTime.now().plusDays(1), null, null);
        TaskDto taskDto = new TaskDto(taskId, "Task Title", "Task Description", "OPEN", LocalDateTime.now(), LocalDateTime.now().plusDays(1), null);

        when(taskRepository.findById(taskId)).thenReturn(Optional.of(taskEntity));
        when(TaskMapper.toDto(any(TaskEntity.class))).thenReturn(taskDto);

        ResponseEntity<TaskDto> response = taskService.getTaskById(taskId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(taskDto, response.getBody());
        verify(taskRepository, times(1)).findById(taskId);
    }

    @Test
    void testGetTasksByUserId() {
        Long userId = 1L;
        List<TaskEntity> taskEntities = Arrays.asList(
                new TaskEntity(1L, "Task 1", "Description 1", "OPEN", LocalDateTime.now(), LocalDateTime.now().plusDays(1), null, null),
                new TaskEntity(2L, "Task 2", "Description 2", "OPEN", LocalDateTime.now(), LocalDateTime.now().plusDays(1), null, null)
        );
        List<TaskDto> taskDtos = Arrays.asList(
                new TaskDto(1L, "Task 1", "Description 1", "OPEN", LocalDateTime.now(), LocalDateTime.now().plusDays(1), null),
                new TaskDto(2L, "Task 2", "Description 2", "OPEN", LocalDateTime.now(), LocalDateTime.now().plusDays(1), null)
        );

        when(taskRepository.findByUserId(userId)).thenReturn(taskEntities);
        when(TaskMapper.toDto(any(TaskEntity.class))).thenReturn(taskDtos.get(0), taskDtos.get(1));

        ResponseEntity<List<TaskDto>> response = taskService.getTasksByUserId(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(taskDtos, response.getBody());
        verify(taskRepository, times(1)).findByUserId(userId);
    }

    @Test
    void testDeleteTask() {
        Long taskId = 1L;

        when(taskRepository.existsById(taskId)).thenReturn(true);
        doNothing().when(taskRepository).deleteById(taskId);

        ResponseEntity<Void> response = taskService.deleteTask(taskId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(taskRepository, times(1)).deleteById(taskId);
    }
}*/