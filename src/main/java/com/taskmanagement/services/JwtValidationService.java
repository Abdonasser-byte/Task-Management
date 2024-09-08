package com.taskmanagement.services;


import com.taskmanagement.dto.UserResponseDto;
import com.taskmanagement.security.JwtUtil;
import com.taskmanagement.exceptions.UnauthorizedException;
import org.springframework.stereotype.Service;

@Service
public class JwtValidationService {

    private final JwtUtil jwtUtil;
    private final UserService userService;

    public JwtValidationService(JwtUtil jwtUtil, UserService userService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    public UserResponseDto validateJwtAndExtractUser(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new UnauthorizedException("Invalid Authorization header");
        }

        String token = authorizationHeader.substring(7);
        String username = jwtUtil.extractUsername(token);

        if (!jwtUtil.validateToken(token, username)) {
            throw new UnauthorizedException("Invalid or expired JWT");
        }

        // Fetch user details from the username extracted from the JWT
        return userService.getUserByUsername(username);
    }
}
