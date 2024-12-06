package christmas.view;

import christmas.domain.vo.OrderMenu;
import christmas.dto.BenefitDetail;
import christmas.dto.BenefitDetailsDto;
import christmas.dto.GiveawayDto;
import java.util.List;

public class ResponseView {
    private final String NEW_LINE = System.lineSeparator();
    private static final String COIN_STATUS = "%d원 - %d개";
    private static final String BlAH_BLAH = "blah_blah";
    private static final String PRODUCT_FORMAT = "%s: %d원, %d개";
    private static final String COIN_MAP_FORMAT = "%s: %d개";
    private static final String MONEY_FORMAT = "%,d원";

    private final ConsoleInputView consoleIn;
    private final ConsoleOutputView consoleOut;

    public ResponseView(final ConsoleInputView consoleIn, final ConsoleOutputView consoleOut) {
        this.consoleIn = consoleIn;
        this.consoleOut = consoleOut;
    }

    /*
    주문 메뉴
     */
    public void printOrderMenusInfo(List<OrderMenu> orderMenus) {
        StringBuilder br = new StringBuilder();
        br.append("<주문 메뉴>").append(NEW_LINE);
        for (OrderMenu menu : orderMenus) {
            br.append(menu.getMenuName()).append(" ").append(menu.getQuantity()).append("개")
                    .append(NEW_LINE);
        }
        String message = br.toString();
        consoleOut.println(message);
    }

    /*
    - ### 할인 전 총주문 금액 출력
     */
    public void printTotalOrderBeforeDiscount(int totalAmount) {
        String message = new StringBuilder()
                .append("<할인 전 총주문 금액>").append(NEW_LINE)
                .append(String.format("%,d원", totalAmount))
                .append(NEW_LINE)
                .toString();
        consoleOut.println(message);
    }

    /*
     <증정 메뉴>
         - 증정 이벤트에 해당하지 않는 경우, 증정 메뉴 "없음"으로 보여 주세요.
     */
    public void printGiveawayMenu(GiveawayDto giveawayDto) {
        StringBuilder br = new StringBuilder();
        br.append("<증정 메뉴>").append(NEW_LINE);
        if (giveawayDto.getGiveawayName() == "없음") {
            br.append(giveawayDto.getGiveawayName()).append(NEW_LINE);

        }
        if (giveawayDto.getGiveawayName() != "없음") {
            br.append(giveawayDto.getGiveawayName()).append(" ").append(giveawayDto.getQuantity()).append("개")
                    .append(NEW_LINE);
        }
        consoleOut.println(br.toString());
    }

    /*
        - ### 혜택 내역 출력
        - 고객에게 적용된 이벤트 내역만 보여 주세요.
        - 적용된 이벤트가 하나도 없다면 혜택 내역 "없음"으로 보여 주세요.
        - 혜택 내역에 여러 개의 이벤트가 적용된 경우, 출력 순서는 자유롭게 출력해주세요.
     */

    public void printBenefitDetails(final BenefitDetailsDto benefitDetailsDto) {
        StringBuilder br = new StringBuilder();
        br.append("<혜택 내역>").append(NEW_LINE);
        if (benefitDetailsDto.isNothing()) {
            br.append("없음");
        }
        if (!benefitDetailsDto.isNothing()) {
            List<BenefitDetail> benefitDetails = benefitDetailsDto.getBenefitDetails();
            for (BenefitDetail detail : benefitDetails) {
                br.append(detail.getName()).append(": -").append(String.format("%,d원", detail.getDiscountAmount()))
                        .append(NEW_LINE);
            }
        }
        consoleOut.println(br.toString());
    }

    /*
        - ### 총혜택 금액 출력
        - 없으면 "0원"
     */
    public void printTotalBenefitAmount(int totalAmount) {

        StringBuilder br = new StringBuilder();
        br.append("<총혜택 금액>").append(NEW_LINE);
        if (totalAmount == 0) {
            br.append("없음")
                    .append(NEW_LINE);
        }
        if (totalAmount != 0) {
            br.append(String.format("-%,d원", totalAmount))
                    .append(NEW_LINE);
        }
        consoleOut.println(br.toString());
    }

    /*
    - ### 할인 후 예상 결제 금액 출력
        - 할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액
     */
    //Estimated payment amount after discount
    public void printEstimatedPaymentAmountAfterDiscount(int totalAmount) {
        String message = new StringBuilder()
                .append("<할인 후 예상 결제 금액>").append(NEW_LINE)
                .append(String.format("%,d원", totalAmount)).append(NEW_LINE)
                .toString();
        consoleOut.println(message);
    }

    /*
        - ### 12월 이벤트 배지 출력
        - 총혜택 금액에 따라 이벤트 배지의 이름을 다르게 보여 주세요.
        - 없으면 "없음"
     */
    public void printEventBadge(String badgeName) {
        StringBuilder br = new StringBuilder();
        br.append("<12월 이벤트 배지>").append(NEW_LINE);
        if (badgeName == "없음") {
            br.append("없음");
        }
        if (badgeName != "없음") {
            br.append(badgeName);
        }
        consoleOut.println(br.toString());
    }

    private String toFormat(String format, Object... args) {
        return String.format(format, args);
    }

    private String toDash(int moveAmount) {
        return "-".repeat(moveAmount);
    }
}
