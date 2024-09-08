package com.taskmanagement.testing.ServicesTests;

/*
import com.ProjectDocker.Project.Dto.UserRequestDto;
import com.ProjectDocker.Project.Dto.UserResponseDto;
import com.ProjectDocker.Project.Mapper.UserMapper;
import com.ProjectDocker.Project.Model.UserEntity;
import com.ProjectDocker.Project.Repositories.UserRepository;
import com.ProjectDocker.Project.Services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        UserRequestDto userRequestDto = new UserRequestDto("username", "password", "email@example.com", null, null);
        UserEntity userEntity = new UserEntity(1L, "username", "password", "email@example.com", null, null);
        UserResponseDto userResponseDto = new UserResponseDto(1L, "username", "email@example.com", null, null);

        when(UserMapper.toEntity(any(UserRequestDto.class))).thenReturn(userEntity);
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);
        when(UserMapper.toResponseDto(any(UserEntity.class))).thenReturn(userResponseDto);

        ResponseEntity<UserResponseDto> response = userService.createUser(userRequestDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(userResponseDto, response.getBody());
        verify(userRepository, times(1)).save(any(UserEntity.class));
    }

    @Test
    void testGetUserById() {
        Long userId = 1L;
        UserEntity userEntity = new UserEntity(userId, "username", "password", "email@example.com", null, null);
        UserResponseDto userResponseDto = new UserResponseDto(userId, "username", "email@example.com", null, null);

        when(userRepository.findById(userId)).thenReturn(Optional.of(userEntity));
        when(UserMapper.toResponseDto(any(UserEntity.class))).thenReturn(userResponseDto);

        ResponseEntity<UserResponseDto> response = userService.getUserById(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userResponseDto, response.getBody());
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void testGetUserByUsername() {
        String username = "username";
        UserEntity userEntity = new UserEntity(1L, "username", "password", "email@example.com", null, null);
        UserResponseDto userResponseDto = new UserResponseDto(1L, "username", "email@example.com", null, null);

        when(userRepository.findByUsername(username)).thenReturn(userEntity);
        when(UserMapper.toResponseDto(any(UserEntity.class))).thenReturn(userResponseDto);

        ResponseEntity<UserResponseDto> response = userService.getUserByUsername(username);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userResponseDto, response.getBody());
        verify(userRepository, times(1)).findByUsername(username);
    }

    @Test
    void testGetAllUsers() {
        List<UserEntity> userEntities = Arrays.asList(
                new UserEntity(1L, "username1", "password1", "email1@example.com", null, null),
                new UserEntity(2L, "username2", "password2", "email2@example.com", null, null)
        );
        List<UserResponseDto> userDtos = Arrays.asList(
                new UserResponseDto(1L, "username1", "email1@example.com", null, null),
                new UserResponseDto(2L, "username2", "email2@example.com", null, null)
        );

        when(userRepository.findAll()).thenReturn(userEntities);
        when(UserMapper.toResponseDto(any(UserEntity.class))).thenReturn(userDtos.get(0), userDtos.get(1));

        ResponseEntity<List<UserResponseDto>> response = userService.getAllUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userDtos, response.getBody());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testDeleteUser() {
        Long userId = 1L;

        when(userRepository.existsById(userId)).thenReturn(true);
        doNothing().when(userRepository).deleteById(userId);

        ResponseEntity<Void> response = userService.deleteUser(userId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(userRepository, times(1)).deleteById(userId);
    }
}*/