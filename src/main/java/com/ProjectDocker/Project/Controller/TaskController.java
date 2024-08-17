package com.ProjectDocker.Project.Controller;


import com.ProjectDocker.Project.Dto.TaskDto;
import com.ProjectDocker.Project.Model.Task;
import com.ProjectDocker.Project.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // FIXME status
    @PostMapping("/create")
    public TaskDto createTask(@RequestBody TaskDto taskDto) {
        return taskService.saveTask(taskDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/user/{userId}")
    public List<TaskDto> getTasksByUser(@PathVariable Long userId) {
        return taskService.getTasksByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}