package ru.java3000.colibrism.api.exception;

public class UserNotFoundException extends ApiException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
