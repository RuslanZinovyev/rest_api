package com.example.rest_api.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException() {
        super("Client Not Found");
    }
}
