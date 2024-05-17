package ru.skypro.homework.exception;

public class AdNotFoundException extends IllegalArgumentException {
    public AdNotFoundException() {
    }

    public AdNotFoundException(String message) {
        super(message);
    }
}
