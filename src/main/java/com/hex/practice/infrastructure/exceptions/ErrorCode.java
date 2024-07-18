package com.hex.practice.infrastructure.exceptions;

public enum ErrorCode {

    MOVIE_ALREADY_EXISTS("1001", "The movie already exists in the database."),
    MOVIE_NOT_FOUND("1002", "The movie was not found."),
    INVALID_REQUEST("1003", "The request is invalid."),
    PERMISSION_DENIED("1004", "You do not have permission to perform this action."),
    UNEXPECTED_ERROR("5000", "An unexpected error has occurred. Please try again later.");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return code + ": " + message;
    }
}
