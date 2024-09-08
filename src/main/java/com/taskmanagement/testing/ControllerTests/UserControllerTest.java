package com.taskmanagement.testing.ControllerTests;

import com.taskmanagement.controller.UserController;
import com.taskmanagement.dto.UserRequestDto;
import com.taskmanagement.dto.UserResponseDto;
import com.taskmanagement.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    public UserControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() throws Exception {
        UserRequestDto userRequestDto = new UserRequestDto("username", "password", "email@example.com", null, null);
        UserResponseDto userResponseDto = new UserResponseDto(1L, "username", "email@example.com", null, null);

        when(userService.createUser(any(UserRequestDto.class)))
                .thenReturn(userResponseDto);  // Mock service to return DTO, not ResponseEntity

        mockMvc.perform(post("/api/v1/users")
                        .header("Authorization", "Bearer token")  // Add authorization header
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(userRequestDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.username").value("username"))
                .andExpect(jsonPath("$.email").value("email@example.com"));

        verify(userService, times(1)).createUser(any(UserRequestDto.class));
    }

    @Test
    void testGetUserById() throws Exception {
        Long userId = 1L;
        UserResponseDto userResponseDto = new UserResponseDto(userId, "username", "email@example.com", null, null);

        when(userService.getUserById(userId))
                .thenReturn(userResponseDto);  // Mock service to return DTO, not ResponseEntity

        mockMvc.perform(get("/api/v1/users/{id}", userId)
                        .header("Authorization", "Bearer token"))  // Add authorization header
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userId))
                .andExpect(jsonPath("$.username").value("username"))
                .andExpect(jsonPath("$.email").value("email@example.com"));

        verify(userService, times(1)).getUserById(userId);
    }

    @Test
    void testGetUserByUsername() throws Exception {
        String username = "username";
        UserResponseDto userResponseDto = new UserResponseDto(1L, "username", "email@example.com", null, null);

        when(userService.getUserByUsername(username))
                .thenReturn(userResponseDto);  // Mock service to return DTO, not ResponseEntity

        mockMvc.perform(get("/api/v1/users/by-username")
                        .header("Authorization", "Bearer token")  // Add authorization header
                        .param("username", username))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.username").value("username"))
                .andExpect(jsonPath("$.email").value("email@example.com"));

        verify(userService, times(1)).getUserByUsername(username);
    }

    @Test
    void testGetAllUsers() throws Exception {
        List<UserResponseDto> users = Arrays.asList(
                new UserResponseDto(1L, "username1", "email1@example.com", null, null),
                new UserResponseDto(2L, "username2", "email2@example.com", null, null)
        );

        when(userService.getAllUsers())
                .thenReturn(users);  // Mock service to return list of users, not ResponseEntity

        mockMvc.perform(get("/api/v1/users")
                        .header("Authorization", "Bearer token"))  // Add authorization header
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].username").value("username1"))
                .andExpect(jsonPath("$[0].email").value("email1@example.com"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].username").value("username2"))
                .andExpect(jsonPath("$[1].email").value("email2@example.com"));

        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testDeleteUser() throws Exception {
        Long userId = 1L;

        doNothing().when(userService).deleteUser(userId);  // Mock void method

        mockMvc.perform(delete("/api/v1/users/{id}", userId)
                        .header("Authorization", "Bearer token"))  // Add authorization header
                .andExpect(status().isNoContent());

        verify(userService, times(1)).deleteUser(userId);
    }
}
