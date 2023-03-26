package com.app.dashboard.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("user not found.");
    }
}
