package com.hex.practice.infrastructure.exceptions;

public class MovieAlreadyExistException  extends RuntimeException {

    private final ErrorCode errorCode;

    public MovieAlreadyExistException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
