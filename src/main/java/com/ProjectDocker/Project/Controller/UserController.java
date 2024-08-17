package com.ProjectDocker.Project.Controller;

import com.ProjectDocker.Project.Dto.UserAddDto;
import com.ProjectDocker.Project.Dto.UserDto;
import com.ProjectDocker.Project.Model.User;
import com.ProjectDocker.Project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserDto registerUser(@RequestBody UserAddDto userAddDto) {

        return userService.saveUser(userAddDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}