package com.taskmanagement.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class TaskDto {
    private final Long id;
    private final String title;
    private final String description;
    private final String status;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final CategoryDto category;

    public boolean isValid() {
        return isValidTitle() && isValidStatus();
    }

    public boolean isValidTitle() {
        return title != null && title.length() >= 3 && title.length() <= 100;
    }

    public boolean isValidStatus() {
        return status != null && !status.isEmpty();
    }
}
