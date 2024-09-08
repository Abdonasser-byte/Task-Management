package com.taskmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class UserResponseDto {

    private final Long id;
    private final String username;
    private final String email;
    private final List<TaskDto> tasks;
    private final List<CategoryDto> categories;
}
