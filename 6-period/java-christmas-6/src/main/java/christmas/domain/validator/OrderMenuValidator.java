package christmas.domain.validator;

import static christmas.constant.ChristmasRule.MENU_QUANTITY_MAX;
import static christmas.constant.ChristmasRule.MENU_QUANTITY_MIN;
import static christmas.constant.ChristmasRule.TOTAL_MENU_QUANTITY_MAX;
import static christmas.constant.ExceptionMessage.INVALID_MENU_QUANTITY_RANGE;
import static christmas.constant.ExceptionMessage.INVALID_MENU_TOTAL_QUANTITY;
import static christmas.constant.ExceptionMessage.MENU_CANT_DUPLICATE;
import static christmas.constant.ExceptionMessage.MENU_CANT_ONLY_DRINK;
import static christmas.constant.ExceptionMessage.NO_EXIST_MENU_MESSAGE;
import static christmas.constant.MenuType.DRINK;
import static christmas.util.ListUtils.hasDuplicates;
import static christmas.util.NumberUtils.isBetweenInclusive;

import christmas.constant.Menu;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class OrderMenuValidator {
    private OrderMenuValidator() {
    }

    public static void validateExistMenu(String menuName) {
        Arrays.stream(Menu.values()).filter(menu -> menu.getDisplayName().equals(menuName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NO_EXIST_MENU_MESSAGE.getMessage()));
    }

    public static void validateDuplicateMenuName(List<String> menuNames) {
        if (hasDuplicates(menuNames)) {
            throw new IllegalArgumentException(MENU_CANT_DUPLICATE.getMessage());
        }
    }

    public static void validateNotOnlyDrinkMenuType(List<String> menuTypes) {
        Set<String> strings = new HashSet<>(menuTypes);
        if (strings.size() == 1 && strings.stream().findFirst().get() == (DRINK.getDisplayName())) {
            throw new IllegalArgumentException(MENU_CANT_ONLY_DRINK.getMessage());
        }
    }

    public static void validateMenuQuantityRange(int quantity) {
        if (!isBetweenInclusive(quantity, MENU_QUANTITY_MIN, MENU_QUANTITY_MAX)) {
            throw new IllegalArgumentException(INVALID_MENU_QUANTITY_RANGE.getMessage());
        }
    }

    public static void validateTotalMenuQuantity(int totalMenuQuantity) {
        if (totalMenuQuantity > TOTAL_MENU_QUANTITY_MAX) {
            throw new IllegalArgumentException(INVALID_MENU_TOTAL_QUANTITY.getMessage());
        }
    }

}
