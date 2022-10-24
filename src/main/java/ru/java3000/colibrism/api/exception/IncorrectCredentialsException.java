package ru.java3000.colibrism.api.exception;

public class IncorrectCredentialsException extends ApiException{
    public IncorrectCredentialsException(String message) {
        super(message);
    }
}
