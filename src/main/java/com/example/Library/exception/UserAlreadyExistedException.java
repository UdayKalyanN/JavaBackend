package com.example.Library.exception;

public class UserAlreadyExistedException extends Exception {
    public UserAlreadyExistedException(String message) {
        super(message);
    }
}
