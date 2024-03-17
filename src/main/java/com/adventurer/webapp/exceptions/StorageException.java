package com.adventurer.webapp.exceptions;

public class StorageException extends RuntimeException{
    public StorageException(String text) {
        super(text);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
