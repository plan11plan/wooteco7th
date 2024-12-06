package christmas.view.mapper;

import static christmas.constant.ExceptionMessage.INVALID_INPUT_FORM;

import christmas.domain.vo.OrderMenu;
import christmas.domain.vo.VisitDate;
import java.util.List;
import java.util.stream.Collectors;

public class ModelMapper {

    private ModelMapper() {
    }

    public static List<OrderMenu> toOrderMenus(String input) {
        String pattern = RequestPattern.createOrderMenusPattern();
        RequestValidator.validateInput(input, pattern, INVALID_INPUT_FORM.getMessage());

        List<List<String>> orderMenus = RequestParser.parseOrderMenus(input);

        return orderMenus.stream()
                .map(details -> {
                    String name = details.get(0);
                    int quantity = Integer.parseInt(details.get(1));
                    return new OrderMenu(name, quantity);
                })
                .collect(Collectors.toList());
    }

    public static VisitDate toVisitDate(final String input) {
        String pattern = RequestPattern.createVisitDatePattern();
        RequestValidator.validateInput(input, pattern, INVALID_INPUT_FORM.getMessage());

        int bonusNumber = RequestParser.parseToInt(input);

        return new VisitDate(bonusNumber);
    }


}
