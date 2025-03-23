package com.schedule.University_schedule.exceptions;

public class DepartmentNotFoundException extends RuntimeException {
    private String message;
    private DepartmentNotFoundException() {}

    public DepartmentNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
