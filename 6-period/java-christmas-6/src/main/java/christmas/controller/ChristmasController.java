package christmas.controller;

import christmas.domain.vo.OrderMenu;
import christmas.dto.BenefitDetail;
import christmas.dto.BenefitDetailsDto;
import christmas.dto.GiveawayDto;
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
        requestView.requestExpectedVisitDate();
        List<OrderMenu> orderMenus = requestView.requestOrderMenus();
        responseView.printOrderMenusInfo(orderMenus);

        responseView.printTotalOrderBeforeDiscount(142_000);
        responseView.printGiveawayMenu(new GiveawayDto("샴페인", 1));
        responseView.printBenefitDetails(new BenefitDetailsDto(
                List.of(new BenefitDetail("크리스마스 디데이 할인", 1_200),
                        new BenefitDetail("평일 할인", 4_046),
                        new BenefitDetail("특별 할인", 1_000),
                        new BenefitDetail("증정 이벤트", 25_000))
        ));
        responseView.printTotalBenefitAmount(31_246);
        responseView.printEstimatedPaymentAmountAfterDiscount(135_754);
        responseView.printEventBadge("산타");

    }
}
