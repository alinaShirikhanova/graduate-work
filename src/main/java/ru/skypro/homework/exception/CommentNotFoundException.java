package ru.skypro.homework.exception;

public class CommentNotFoundException extends IllegalArgumentException {
    public CommentNotFoundException() {
    }

    public CommentNotFoundException(String message) {
        super(message);
    }
}
