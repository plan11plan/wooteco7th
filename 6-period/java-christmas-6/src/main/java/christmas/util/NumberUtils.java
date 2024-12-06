package christmas.util;

public class NumberUtils {
    private NumberUtils() {
    }

    public static boolean isBetweenInclusive(int target, int min, int max) {
        return target >= min && target <= max;
    }
}
