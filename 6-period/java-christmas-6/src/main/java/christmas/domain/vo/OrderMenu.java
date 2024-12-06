package christmas.domain.vo;

import christmas.domain.validator.OrderMenuValidator;

public class OrderMenu {
    private final String menuName;
    private final int quantity;

    public OrderMenu(final String menuName, final int quantity) {
        OrderMenuValidator.validateExistMenu(menuName);
        OrderMenuValidator.validateMenuQuantityRange(quantity);

        this.menuName = menuName;
        this.quantity = quantity;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderMenu{" +
                "menuName='" + menuName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
