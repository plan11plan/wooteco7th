package christmas.repository;

import christmas.domain.Order;
import java.util.HashMap;
import java.util.Map;

public class OrderRepository {
    private final Map<Long, Order> repository = new HashMap<>();

    public OrderRepository() {
    }

    public Long save(Order order) {
        repository.put(order.getId(), order);
        return order.getId();
    }

    public Order findBydId(final Long orderId) {
        return repository.get(orderId);
    }
}
