package com.taskmanagement.services;



import com.taskmanagement.dto.UserRequestDto;
import com.taskmanagement.dto.UserResponseDto;
import com.taskmanagement.mapper.UserMapper;
import com.taskmanagement.model.UserEntity;
import com.taskmanagement.repositories.UserRepository;
import com.taskmanagement.exceptions.ConflictException;
import com.taskmanagement.exceptions.UnauthorizedException;
import com.taskmanagement.exceptions.UserNotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class UserService  {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto authenticateUser(String email, String password) {

        return userRepository.findByEmail(email)
                .map(UserMapper::toResponseDto)
                .orElseThrow(()-> new UnauthorizedException("This is User is Unauthorized"));
    }

    public UserResponseDto getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserMapper::toResponseDto)
                .orElseThrow(()-> new UserNotFoundException("I cant Find User " + email));
    }

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        if (userRepository.existsByUsername(userRequestDto.getUsername())) {
            throw new ConflictException("We already Have this user");
        }

        UserEntity userEntity = UserMapper.toEntity(userRequestDto);
        UserResponseDto savedUser = UserMapper.toResponseDto(userRepository.save(userEntity));

        return savedUser;
    }

    // Get user by ID
    public UserResponseDto getUserById(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::toResponseDto)
                .orElseThrow(()-> new UserNotFoundException("We can't find this user"+id));
    }

    // Get user by username
    public UserResponseDto getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(UserMapper::toResponseDto)
                .orElseThrow(()-> new UsernameNotFoundException("I cant Find User "+ username));
    }

    public List<UserResponseDto> getAllUsers() {
        List<UserResponseDto> userDtos = userRepository.findAll().stream()
                .map(UserMapper::toResponseDto)
                .collect(Collectors.toList());
        return userDtos;
    }

    // Delete user by ID
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UsernameNotFoundException("We can't Find this user " + id);
        }
        userRepository.deleteById(id);
    }


}

