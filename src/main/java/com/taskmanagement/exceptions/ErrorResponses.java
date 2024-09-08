package com.taskmanagement.exceptions;

public class ErrorResponses {

    private String errorCode;
    private String errorMessage;

    // No-argument constructor (required for deserialization)
    public ErrorResponses() {}

    // Constructor with arguments
    public ErrorResponses(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    // Getters and setters
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}


