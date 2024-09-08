package com.taskmanagement.controller;

import com.taskmanagement.dto.TaskDto;
import com.taskmanagement.services.JwtValidationService;
import com.taskmanagement.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final JwtValidationService jwtValidationService;
    private final TaskService taskService;

    public TaskController(TaskService taskService, JwtValidationService jwtValidationService) {
        this.taskService = taskService;
        this.jwtValidationService = jwtValidationService;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createOrUpdateTask(@RequestHeader("Authorization") String authorizationHeader,
                                                      @RequestBody TaskDto taskDto) {
        jwtValidationService.validateJwtAndExtractUser(authorizationHeader);  // Validate JWT
        TaskDto savedTask = taskService.saveTask(taskDto);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@RequestHeader("Authorization") String authorizationHeader,
                                               @PathVariable Long id) {
        jwtValidationService.validateJwtAndExtractUser(authorizationHeader);  // Validate JWT
        TaskDto savedTask = taskService.getTaskById(id);
        return new ResponseEntity<>(savedTask, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TaskDto>> getTasksByUserId(@RequestHeader("Authorization") String authorizationHeader,
                                                          @PathVariable Long userId) {
        jwtValidationService.validateJwtAndExtractUser(authorizationHeader);  // Validate JWT
        List<TaskDto> userTasks = taskService.getTasksByUserId(userId);
        return new ResponseEntity<>(userTasks, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@RequestHeader("Authorization") String authorizationHeader,
                                           @PathVariable Long id) {
        jwtValidationService.validateJwtAndExtractUser(authorizationHeader);  // Validate JWT
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
