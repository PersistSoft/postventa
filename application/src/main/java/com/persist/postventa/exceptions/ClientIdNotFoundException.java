package com.persist.postventa.exceptions;

public class ClientIdNotFoundException extends RuntimeException {
    public ClientIdNotFoundException(String message) {
        super(message);
    }
}
