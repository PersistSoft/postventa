package com.persist.postventa.exceptions;

public class ApartmentNotFoundException extends RuntimeException {
    public ApartmentNotFoundException(String message) {
        super(message);
    }
}
