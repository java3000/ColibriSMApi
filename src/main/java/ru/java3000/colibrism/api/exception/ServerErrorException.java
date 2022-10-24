package ru.java3000.colibrism.api.exception;

public class ServerErrorException extends ApiException{
    public ServerErrorException(String message) {
        super(message);
    }
}
