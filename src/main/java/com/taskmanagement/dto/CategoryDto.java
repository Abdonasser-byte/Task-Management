package com.taskmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CategoryDto {


    private final Long id;
    private final String title;
    private final List<TaskDto> tasks;
    private final UserResponseDto user;

    public boolean isValid() {
        return isValidTitle();
    }

    public boolean isValidTitle() {
        return title != null && !title.isEmpty();
    }
}
