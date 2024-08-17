package com.ProjectDocker.Project.Services;


import com.ProjectDocker.Project.Dto.TaskDto;
import com.ProjectDocker.Project.Dto.UserDto;
import com.ProjectDocker.Project.Mapper.TaskMapper;
import com.ProjectDocker.Project.Mapper.UserMapper;
import com.ProjectDocker.Project.Model.Task;
import com.ProjectDocker.Project.Model.User;
import com.ProjectDocker.Project.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskDto saveTask(TaskDto taskDto) {
        return TaskMapper.toDto(taskRepository.save(TaskMapper.toEntity(taskDto)));
    }

    public ResponseEntity<TaskDto> getTaskById(Long id) {
        return (taskRepository.findById(id)).map(task -> ResponseEntity.ok(TaskMapper.toDto(task)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    public List<TaskDto> getTasksByUserId(Long taskId) {
        List<Task> listTask =taskRepository.findAll();
        List<TaskDto> ListtaskDto = new ArrayList<>();;
        for (Task task: listTask){
            ListtaskDto.add(TaskMapper.toDto(task));
        }
        return ListtaskDto;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}