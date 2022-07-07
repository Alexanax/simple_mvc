package org.example.app.exceptions;

public class RemoveByRegexException extends Exception {
    private final String message;

    public RemoveByRegexException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
