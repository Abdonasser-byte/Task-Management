package com.taskmanagement.controller;

import com.taskmanagement.dto.UserRequestDto;
import com.taskmanagement.dto.UserResponseDto;
import com.taskmanagement.services.JwtValidationService;
import com.taskmanagement.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final JwtValidationService jwtValidationService;
    private final UserService userService;

    public UserController(UserService userService, JwtValidationService jwtValidationService) {
        this.userService = userService;
        this.jwtValidationService = jwtValidationService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestHeader("Authorization") String authorizationHeader,
                                                      @RequestBody UserRequestDto userRequestDto) {
        jwtValidationService.validateJwtAndExtractUser(authorizationHeader);  // Validate JWT
        UserResponseDto userResponse = userService.createUser(userRequestDto);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@RequestHeader("Authorization") String authorizationHeader,
                                                       @PathVariable Long id) {
        jwtValidationService.validateJwtAndExtractUser(authorizationHeader);  // Validate JWT
        UserResponseDto userResponse = userService.getUserById(id);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @GetMapping("/by-username")
    public ResponseEntity<UserResponseDto> getUserByUsername(@RequestHeader("Authorization") String authorizationHeader,
                                                             @RequestParam String username) {
        jwtValidationService.validateJwtAndExtractUser(authorizationHeader);  // Validate JWT
        UserResponseDto userResponse = userService.getUserByUsername(username);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers(@RequestHeader("Authorization") String authorizationHeader) {
        jwtValidationService.validateJwtAndExtractUser(authorizationHeader);  // Validate JWT
        List<UserResponseDto> userResponse = userService.getAllUsers();
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@RequestHeader("Authorization") String authorizationHeader,
                                           @PathVariable Long id) {
        jwtValidationService.validateJwtAndExtractUser(authorizationHeader);  // Validate JWT
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
