package com.schedule.University_schedule.exceptions;

public class AccountException extends RuntimeException {
    private String message;
    private AccountException() {}

    public AccountException(String message) {
        super(message);
        this.message = message;
    }
}
