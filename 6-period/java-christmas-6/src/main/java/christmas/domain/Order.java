package christmas.domain;

import christmas.domain.vo.OrderMenu;
import java.time.LocalDate;
import java.util.List;

public class Order {
    private final long id;
    private final LocalDate localDate;
    private final List<OrderMenu> orderMenus;
    private final int discountAmount;

    public Order(final long id, final int day, final List<OrderMenu> orderMenus, final int discountAmount) {
        this.id = id;
        this.localDate = LocalDate.of(2023, 11, day);
        this.orderMenus = orderMenus;
        this.discountAmount = discountAmount;
    }

    public long getId() {
        return id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public List<OrderMenu> getOrderMenus() {
        return orderMenus;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public int getTotalAmount() {
        return orderMenus.stream().mapToInt(orderMenu -> orderMenu.getQuantity()).sum();
    }

    public int getEstimatedPaymentAmountAfterDiscount() {
        return getTotalAmount() - getDiscountAmount();
    }

    public boolean isDiscountAmountOverOrEqual(int target) {
        return getDiscountAmount() >= target;
    }
}
