package com.ProjectDocker.Project.Services;


import com.ProjectDocker.Project.Dto.UserAddDto;
import com.ProjectDocker.Project.Dto.UserDto;
import com.ProjectDocker.Project.Mapper.UserAddMapper;
import com.ProjectDocker.Project.Mapper.UserMapper;
import com.ProjectDocker.Project.Model.User;
import com.ProjectDocker.Project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto saveUser(UserAddDto useraddDto) {
        return UserAddMapper.toDto(userRepository.save(UserAddMapper.toEntity(useraddDto)));
    }

    public ResponseEntity<UserDto> getUserById(Long id) {
        return (userRepository.findById(id)).map(user -> ResponseEntity.ok(UserMapper.toDto(user)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public UserDto getUserByUsername(String username) {
        return UserMapper.toDto(userRepository.findByUsername(username));
    }

    public List<UserDto> getAllUsers() {
        List<User> listUsers =userRepository.findAll();
        List<UserDto> listUserDto = new ArrayList<>();;
        for (User user: listUsers){
            listUserDto.add(UserMapper.toDto(user));
        }
        return listUserDto;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}