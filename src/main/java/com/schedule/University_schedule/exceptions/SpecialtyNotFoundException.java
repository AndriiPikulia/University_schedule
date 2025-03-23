package com.schedule.University_schedule.exceptions;

public class SpecialtyNotFoundException extends RuntimeException {
    private String message;
    public SpecialtyNotFoundException() {}

    public SpecialtyNotFoundException(String message) {
        super(message);
    }
}
