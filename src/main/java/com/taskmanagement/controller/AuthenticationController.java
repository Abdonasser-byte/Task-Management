package com.taskmanagement.controller;

import com.taskmanagement.dto.AuthenticationResponseDto;
import com.taskmanagement.dto.UserRequestDto;
import com.taskmanagement.dto.UserResponseDto;
import com.taskmanagement.services.UserService;
import com.taskmanagement.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    public AuthenticationController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserService userService) {
        System.out.println(authenticationManager.toString());
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    public AuthenticationResponseDto createAuthenticationToken(@RequestBody UserRequestDto authenticationRequest) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            throw new Exception("Invalid credentials", e);
        }


        UserResponseDto userResponseDto = userService.getUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userResponseDto.getUsername(), new HashMap<>());

        return AuthenticationResponseDto.builder()
                .user(userResponseDto)
                .jwt(jwt)
                .build();
    }

    @PostMapping("/register")
    public UserResponseDto registerUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }
}
