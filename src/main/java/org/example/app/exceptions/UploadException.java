package org.example.app.exceptions;

public class UploadException extends Exception {
    private final String message;

    public UploadException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
