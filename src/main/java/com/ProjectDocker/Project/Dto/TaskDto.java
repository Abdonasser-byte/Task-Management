package com.ProjectDocker.Project.Dto;

import com.ProjectDocker.Project.Model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class TaskDto {
    private Long id;

    private String title;

    private String description;

    private String status;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodFrom(LocalDateTime periodFrom) {
        this.periodFrom = periodFrom;
    }

    public LocalDateTime getPeriodTo() {
        return periodTo;
    }

    public void setPeriodTo(LocalDateTime periodTo) {
        this.periodTo = periodTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    private LocalDateTime periodFrom;

    private LocalDateTime periodTo;

    private Category category;
}
