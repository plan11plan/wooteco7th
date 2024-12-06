package christmas.controller;

import christmas.domain.vo.OrderMenu;
import christmas.dto.BenefitDetail;
import christmas.dto.BenefitDetailsDto;
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
//        List<OrderMenu> orderMenus = requestView.requestOrderMenus();
//        responseView.printOrderMenusInfo(orderMenus);
        responseView.printOrderMenusInfo(List.of(
                new OrderMenu("티본스테이크 ", 1),
                new OrderMenu("바비큐립", 1),
                new OrderMenu("초코케이크", 2),
                new OrderMenu("제로콜라", 1)

        ));
        responseView.printTotalOrderBeforeDiscount(142_000);
        responseView.printBenefitDetails(new BenefitDetailsDto(
                List.of(new BenefitDetail("크리스마스 디데이 할인", 1_200),
                        new BenefitDetail("평일 할인", 4_046),
                        new BenefitDetail("특별 할인", 1_000),
                        new BenefitDetail("증정 이벤트", 25_000))
        ));
        responseView.printTotalOrderAfterDiscount(31_426);
        responseView.printEstimatedPaymentAmountAfterDiscount(135_754);
        responseView.printEventBadge("산타");


    }
}
