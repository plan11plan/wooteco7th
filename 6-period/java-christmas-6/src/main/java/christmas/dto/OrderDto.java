package christmas.dto;

import christmas.domain.vo.OrderMenu;
import christmas.domain.vo.VisitDate;
import java.util.List;

public class OrderDto {
    private final Long id;
    private final VisitDate visitDate;
    private final List<OrderMenu> orderMenus;

    public OrderDto(final Long id, final VisitDate visitDate, final List<OrderMenu> orderMenus) {
        this.id = id;
        this.visitDate = visitDate;
        this.orderMenus = orderMenus;
    }

    public Long getId() {
        return id;
    }

    public VisitDate getVisitDate() {
        return visitDate;
    }

    public List<OrderMenu> getOrderMenus() {
        return orderMenus;
    }
}
