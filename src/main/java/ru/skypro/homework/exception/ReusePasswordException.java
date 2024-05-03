package ru.skypro.homework.exception;

public class ReusePasswordException extends RuntimeException {
    public ReusePasswordException() {
    }

    public ReusePasswordException(String message) {
        super(message);
    }

    public ReusePasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
