package ru.skypro.homework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Photo Not Found")
public class PhotoNotFoundException extends IllegalArgumentException{
    public PhotoNotFoundException() {
    }

    public PhotoNotFoundException(String s) {
        super(s);
    }
}
