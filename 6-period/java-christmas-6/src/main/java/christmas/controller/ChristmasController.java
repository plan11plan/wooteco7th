package christmas.controller;

import christmas.domain.vo.OrderMenu;
import christmas.domain.vo.VisitDate;
import christmas.dto.BenefitDetailsDto;
import christmas.dto.GiveawayDto;
import christmas.dto.OrderDto;
import christmas.service.ChristmasService;
import christmas.view.RequestView;
import christmas.view.ResponseView;
import java.util.List;

public class ChristmasController {
    private final RequestView requestView;
    private final ResponseView responseView;
    private final ChristmasService christmasService;

    public ChristmasController(final RequestView requestView, final ResponseView responseView,
                               final ChristmasService christmasService) {
        this.requestView = requestView;
        this.responseView = responseView;
        this.christmasService = christmasService;
    }

    public void run() {
        OrderDto orderDto = createOrder();

        getTotalOrderBeforeDiscount(orderDto.getId());
        getGiveawayMenu(orderDto.getId());
        getBenefitDetails(orderDto);
        getTotalBenefitAmount(orderDto.getId());
        getEstimatedPaymentAmountAfterDiscount(orderDto.getId());
        getEventBadge(orderDto.getId());
    }

    private void getEventBadge(final Long orderId) {
        String result = christmasService.getEventBadge(orderId);
        responseView.printEventBadge(result);

    }

    private void getEstimatedPaymentAmountAfterDiscount(final long orderId) {
        int result = christmasService.getEstimatedPaymentAmountAfterDiscount(orderId);
        responseView.printEstimatedPaymentAmountAfterDiscount(result);
    }

    private void getTotalBenefitAmount(long orderId) {
        int result = christmasService.getTotalBenefitAmount(orderId);
        responseView.printTotalBenefitAmount(result);
    }

    private void getBenefitDetails(final OrderDto orderDto) {
        BenefitDetailsDto benefitDetailsDto = christmasService.getBenefitDetails(orderDto.getId());
        responseView.printBenefitDetails(benefitDetailsDto);
    }

    private void getGiveawayMenu(final long orderId) {
        GiveawayDto giveawayDto = christmasService.createGiveawayMenu(orderId);
        responseView.printGiveawayMenu(giveawayDto);
    }

    private void getTotalOrderBeforeDiscount(final long orderId) {
        int result = christmasService.calculateTotalOrderBeforeDiscount(orderId);
        responseView.printTotalOrderBeforeDiscount(result);
    }

    private OrderDto createOrder() {
        VisitDate visitDate = requestView.requestExpectedVisitDate();
        List<OrderMenu> orderMenus = requestView.requestOrderMenus();
        OrderDto orderDto = christmasService.createOrder(visitDate, orderMenus);
        responseView.printOrderMenusInfo(orderDto.getOrderMenus());
        return orderDto;
    }
}
