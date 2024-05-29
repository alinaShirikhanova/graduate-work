package ru.skypro.homework.util.response;


import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import ru.skypro.homework.util.EntityEnum;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@UtilityClass
public class ResponseUtil {
    public String getNotFoundDescription(EntityEnum entity, String fieldName, String value) {
        log.info("{} with {} = {} not found.", entity.getName(), fieldName, value);
        return String.format("%s with %s = %s not found.", entity.getName(), fieldName, value);
    }
}
