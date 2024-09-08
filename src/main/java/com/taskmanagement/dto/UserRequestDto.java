package com.taskmanagement.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
// User Record

public class UserRequestDto {

    private long id = 1 ;
    private final String username;
    private final String password;
    private final String email;
    private final List<TaskDto> tasks;
    private final List<CategoryDto> categories;

    public UserRequestDto(String username, String password, String email, List<TaskDto> tasks, List<CategoryDto> categories) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.tasks = tasks;
        this.categories = categories;
    }

    @JsonCreator
    public UserRequestDto(
            @JsonProperty("id") long id,
            @JsonProperty("username") String username,
            @JsonProperty("password") String password,
            @JsonProperty("email") String email,
            @JsonProperty("tasks") List<TaskDto> tasks,
            @JsonProperty("categories") List<CategoryDto> categories) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.tasks = tasks;
        this.categories = categories;
    }
    public boolean isValid() {
        return isValidUsername() && isValidPassword() && isValidEmail();
    }

    public boolean isValidUsername() {
        return username != null && username.length() >= 3 && username.length() <= 50;
    }

    public boolean isValidPassword() {
        return password != null && password.length() >= 6;
    }

    public boolean isValidEmail() {
        return email != null && email.contains("@");
    }
}
