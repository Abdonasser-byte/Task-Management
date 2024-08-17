package com.ProjectDocker.Project.Dto;

import com.ProjectDocker.Project.Model.Task;
import com.ProjectDocker.Project.Model.User;
import jakarta.persistence.*;

import java.util.List;

public class CategoryDto {
    private Long id;

    private String title;

    private List<Task> tasks;

    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
