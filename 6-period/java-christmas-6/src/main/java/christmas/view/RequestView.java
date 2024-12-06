package christmas.view;

import static christmas.util.RetryOnExceptionTemplate.retryOnException;

import christmas.domain.vo.OrderMenu;
import christmas.domain.vo.VisitDate;
import christmas.view.io.ConsoleInputView;
import christmas.view.io.ConsoleOutputView;
import christmas.view.mapper.ModelMapper;
import java.util.List;
import java.util.function.Function;

/*
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
26
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
타파스-1,제로콜라-1
12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
 */
public class RequestView {
    private final String NEW_LINE = System.lineSeparator();
    private final String START_HEADER = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private final String REQUEST_VISIT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    private final String REQUEST_ORDER_MENUS = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private final ConsoleInputView consoleIn;
    private final ConsoleOutputView consoleOut;

    public RequestView(final ConsoleInputView consoleIn, final ConsoleOutputView consoleOut) {
        this.consoleIn = consoleIn;
        this.consoleOut = consoleOut;
    }

    public VisitDate requestExpectedVisitDate() {
        String message = new StringBuilder()
                .append(START_HEADER).append(NEW_LINE)
                .append(REQUEST_VISIT_DATE)
                .toString();
        return request(message, ModelMapper::toVisitDate);
    }

    public List<OrderMenu> requestOrderMenus() {
        String message = new StringBuilder()
                .append(REQUEST_ORDER_MENUS).toString();

        return request(message, ModelMapper::toOrderMenus);
    }

    private <T> T request(String message, Function<String, T> mapper) {
        return retryOnException(() -> {
            consoleOut.println(message);
            String input = consoleIn.readLine();
            return mapper.apply(input);
        });
    }

//
//    public static void main(String[] args) {
//
//        RequestView requestView = new RequestView();
//        requestView.requestExpectedVisitDate();
//        requestView.requestOrderMenus();
//    }

}
