package com.trungtd.departmentservice.custom.exception;

public class ExistsException extends RuntimeException{
    public ExistsException(String message) {
        super(message);
    }
}
