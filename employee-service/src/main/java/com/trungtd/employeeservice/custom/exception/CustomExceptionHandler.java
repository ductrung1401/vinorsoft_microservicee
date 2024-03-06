package com.trungtd.employeeservice.custom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse NotFoundExceptionHandler(NotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());
        System.out.println(errorResponse);
        return errorResponse;
    }

    @ExceptionHandler(ExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse ExistsExceptionHandler(ExistsException e) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        System.out.println(errorResponse);
        return errorResponse;
    }
}
