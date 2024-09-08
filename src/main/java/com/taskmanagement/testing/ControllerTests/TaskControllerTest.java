package com.taskmanagement.testing.ControllerTests;

/*
import com.ProjectDocker.Project.Controller.TaskController;
import com.ProjectDocker.Project.Dto.TaskDto;
import com.ProjectDocker.Project.Services.TaskService;
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

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @MockBean
    private TaskService taskService;

    public TaskControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateOrUpdateTask() throws Exception {
        TaskDto taskDto = new TaskDto(1L, "Task Title", "Task Description", "OPEN", null, null, null);

        when(taskService.saveTask(any(TaskDto.class)))
                .thenReturn(new ResponseEntity<>(taskDto, HttpStatus.CREATED));

        mockMvc.perform(post("/api/v1/tasks")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(taskDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Task Title"));

        verify(taskService, times(1)).saveTask(any(TaskDto.class));
    }

    @Test
    void testGetTaskById() throws Exception {
        Long taskId = 1L;
        TaskDto taskDto = new TaskDto(taskId, "Task Title", "Task Description", "OPEN", null, null, null);

        when(taskService.getTaskById(taskId))
                .thenReturn(new ResponseEntity<>(taskDto, HttpStatus.OK));

        mockMvc.perform(get("/api/v1/tasks/{id}", taskId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(taskId))
                .andExpect(jsonPath("$.title").value("Task Title"));

        verify(taskService, times(1)).getTaskById(taskId);
    }

    @Test
    void testGetTasksByUserId() throws Exception {
        Long userId = 1L;
        List<TaskDto> tasks = Arrays.asList(
                new TaskDto(1L, "Task 1", "Description 1", "OPEN", null, null, null),
                new TaskDto(2L, "Task 2", "Description 2", "OPEN", null, null, null)
        );

        when(taskService.getTasksByUserId(userId))
                .thenReturn(new ResponseEntity<>(tasks, HttpStatus.OK));

        mockMvc.perform(get("/api/v1/tasks/user/{userId}", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].title").value("Task 1"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].title").value("Task 2"));

        verify(taskService, times(1)).getTasksByUserId(userId);
    }

    @Test
    void testDeleteTask() throws Exception {
        Long taskId = 1L;

        when(taskService.deleteTask(taskId)).thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));

        mockMvc.perform(delete("/api/v1/tasks/{id}", taskId))
                .andExpect(status().isNoContent());

        verify(taskService, times(1)).deleteTask(taskId);
    }
}*/