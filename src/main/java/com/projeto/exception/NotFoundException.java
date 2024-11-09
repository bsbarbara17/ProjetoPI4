package com.projeto.exception;

public class NotFoundException extends RuntimeException {

    // Construtor com uma mensagem personalizada
    public NotFoundException(String message) {
        super(message);
    }

    // Construtor com mensagem personalizada e causa
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
