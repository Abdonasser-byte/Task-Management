package com.ProjectDocker.Project.Dto;

import com.ProjectDocker.Project.Model.Category;
import com.ProjectDocker.Project.Model.Task;
import com.ProjectDocker.Project.Model.User;

import java.util.List;

public class UserDto {
    private Long id;

    private String username;


    private String email;

    private List<Task> tasks;

    private List<Category> categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
