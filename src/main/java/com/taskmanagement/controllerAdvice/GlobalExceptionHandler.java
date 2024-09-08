package com.taskmanagement.controllerAdvice;

import com.ProjectDocker.Project.exceptions.*;
import com.taskmanagement.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    // Handle unauthorized access
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponses> handleUnauthorizedException(UnauthorizedException ex) {
        ErrorResponses errorResponse = new ErrorResponses("UNAUTHORIZED", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    // Handle user not found
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponses> handleUserNotFoundException(UserNotFoundException ex) {
        ErrorResponses errorResponse = new ErrorResponses("USER_NOT_FOUND", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Handle task not found
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorResponses> handleTaskNotFoundException(TaskNotFoundException ex) {
        ErrorResponses errorResponse = new ErrorResponses("TASK_NOT_FOUND", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Handle category not found
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponses> handleCategoryNotFoundException(CategoryNotFoundException ex) {
        ErrorResponses errorResponse = new ErrorResponses("CATEGORY_NOT_FOUND", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Handle conflict (e.g., username already exists)
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponses> handleConflictException(ConflictException ex) {
        ErrorResponses errorResponse = new ErrorResponses("CONFLICT", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    // Handle generic exceptions (catch-all)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponses> handleGenericException(Exception ex) {
        ErrorResponses errorResponse = new ErrorResponses("INTERNAL_SERVER_ERROR", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
