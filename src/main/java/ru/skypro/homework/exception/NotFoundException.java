package ru.skypro.homework.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class NotFoundException extends RuntimeException {
    public NotFoundException(String description) {
        super(description);
    }
}
