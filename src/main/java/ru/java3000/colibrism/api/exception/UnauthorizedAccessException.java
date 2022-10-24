package ru.java3000.colibrism.api.exception;

public class UnauthorizedAccessException extends ApiException{
    public UnauthorizedAccessException(String message) {
        super(message);
    }
}
