package com.hex.practice.infrastructure.exceptions;

public class MovieNotFoundException extends RuntimeException {

    private final ErrorCode errorCode;

    public MovieNotFoundException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
