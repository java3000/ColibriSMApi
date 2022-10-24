package ru.java3000.colibrism.api.exception;

public class UserAlreadyExistException extends ApiException{
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
