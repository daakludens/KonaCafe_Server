package com.konacafe.exception;

public class StoreDuplicatedException extends RuntimeException {

    public StoreDuplicatedException(String message) {
        super(message);
    }
}
