package christmas.util;

import static christmas.constant.ExceptionMessage.CANT_NULL;
import static christmas.constant.ExceptionMessage.CANT_NULL_OR_EMPTY;
import static christmas.constant.ExceptionMessage.INVALID_INTEGER_TYPE;

import java.util.List;
import java.util.Objects;

public class ValidationUtils {
    private ValidationUtils() {
    }

    public static void validateNullOrEmpty(String value) {
        if (Objects.isNull(value) || value.trim().isEmpty()) {
            throw new IllegalArgumentException(CANT_NULL_OR_EMPTY.getMessage());
        }
    }

    public static void validateNullOrEmpty(List<?> list) {
        if (Objects.isNull(list) || list.isEmpty()) {
            throw new IllegalArgumentException(CANT_NULL_OR_EMPTY.getMessage());
        }
    }

    public static <T> void validateNull(T object) {
        if (Objects.isNull(object)) {
            throw new IllegalArgumentException(CANT_NULL.getMessage());
        }
    }

    public static void validateInteger(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INTEGER_TYPE.getMessage());
        }
    }

}
