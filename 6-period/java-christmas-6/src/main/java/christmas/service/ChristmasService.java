package christmas.service;

import static christmas.constant.Badge.SANTA;
import static christmas.constant.Badge.TREE;

import christmas.domain.Order;
import christmas.domain.vo.OrderMenu;
import christmas.domain.vo.VisitDate;
import christmas.dto.BenefitDetail;
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
        Order order = new Order(1L, visitDate.getValue(), orderMenus, 0);
        Long savedId = orderRepository.save(order);
        return new OrderDto(savedId, visitDate, orderMenus);
    }

    public int calculateTotalOrderBeforeDiscount(final long orderId) {
        Order order = orderRepository.findBydId(orderId);
        return order.getTotalAmount();
    }


    public GiveawayDto createGiveawayMenu(final long orderId) {
        Order order = orderRepository.findBydId(orderId);
        if (order.getTotalAmount() < 25_000) {
            return new GiveawayDto("없음", 0);
        }
        return new GiveawayDto("샴페인", 1);
    }

    public BenefitDetailsDto getBenefitDetails(final long orderId) {
        Order order = orderRepository.findBydId(orderId);
        List<BenefitDetail> benefitDetails = List.of(new BenefitDetail("sd", 12));
        return new BenefitDetailsDto(benefitDetails);
    }

    public int getTotalBenefitAmount(final long orderId) {
        Order order = orderRepository.findBydId(orderId);

        return order.getDiscountAmount();
    }

    public int getEstimatedPaymentAmountAfterDiscount(final Long orderId) {
        Order order = orderRepository.findBydId(orderId);

        return order.getEstimatedPaymentAmountAfterDiscount();
    }

    public String getEventBadge(final Long orderId) {
        Order order = orderRepository.findBydId(orderId);
        if (order.isDiscountAmountOverOrEqual(20_000)) {
            return SANTA.getDisplayName();
        }
        if (order.isDiscountAmountOverOrEqual(10_000)) {
            return TREE.getDisplayName();
        }
        if (order.isDiscountAmountOverOrEqual(5_000)) {
            return SANTA.getDisplayName();
        }
        return "없음";

    }
}
