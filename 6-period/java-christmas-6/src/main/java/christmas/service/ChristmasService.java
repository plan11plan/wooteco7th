package christmas.service;

import christmas.domain.Order;
import christmas.domain.vo.OrderMenu;
import christmas.domain.vo.VisitDate;
import christmas.dto.BenefitDetailsDto;
import christmas.dto.GiveawayDto;
import christmas.dto.OrderDto;
import christmas.repository.OrderRepository;
import java.util.List;

public class ChristmasService {
    private final OrderRepository orderRepository;

    public ChristmasService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDto createOrder(final VisitDate visitDate, final List<OrderMenu> orderMenus) {
        Order order = new Order(1L, visitDate.getValue(), orderMenus);
        Long savedId = orderRepository.save(order);
        return new OrderDto(savedId, visitDate, orderMenus);
    }

    public int calculateTotalOrderBeforeDiscount(final long orderId) {
        Order order = orderRepository.findBydId(orderId);
        return 0;
    }


    public GiveawayDto createGiveawayMenu(final long totalBeforeDiscount) {
        return null;
    }

    public BenefitDetailsDto getBenefitDetails(final long id) {

        return null;
    }

    public int getTotalBenefitAmount(final long orderId) {
        return 0;
    }

    public int getEstimatedPaymentAmountAfterDiscount(final Long id) {
        return 0;
    }

    public String getEventBadge(final Long orderId) {
        return null;
    }
}
