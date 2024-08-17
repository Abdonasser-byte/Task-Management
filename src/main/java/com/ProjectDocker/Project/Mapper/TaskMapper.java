package com.ProjectDocker.Project.Mapper;

import com.ProjectDocker.Project.Dto.TaskDto;
import com.ProjectDocker.Project.Model.Task;

public class TaskMapper{

    public  static TaskDto toDto(Task task){
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setStatus(task.getStatus());
        taskDto.setCategory(task.getCategory());
        return taskDto;
    }

    public static Task toEntity(TaskDto taskDto){
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());
        task.setCategory(taskDto.getCategory());
        return task;
    }
}
