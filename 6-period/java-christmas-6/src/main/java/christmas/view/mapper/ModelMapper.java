package christmas.view.mapper;

import static christmas.constant.ExceptionMessage.INVALID_MENU_FORM;
import static christmas.constant.ExceptionMessage.INVALID_VISIT_DATE_RANGE;

import christmas.domain.validator.ExpectedVisitDateValidator;
import christmas.domain.validator.OrderMenuValidator;
import christmas.domain.vo.OrderMenu;
import christmas.domain.vo.VisitDate;
import java.util.List;
import java.util.stream.Collectors;

public class ModelMapper {

    private ModelMapper() {
    }

    public static List<OrderMenu> toOrderMenus(String input) {
        String pattern = RequestPattern.createOrderMenusPattern();
        RequestValidator.validateInput(input, pattern, INVALID_MENU_FORM.getMessage());

        List<List<String>> orderMenus = RequestParser.parseOrderMenus(input);

        return orderMenus.stream()
                .map(details -> {
                    String name = details.get(0);
                    OrderMenuValidator.validateExistMenu(name);
                    int quantity = Integer.parseInt(details.get(1));
                    return new OrderMenu(name, quantity);
                })
                .collect(Collectors.toList());
    }

    public static VisitDate toVisitDate(final String input) {
        String pattern = RequestPattern.createVisitDatePattern();
        RequestValidator.validateInput(input, pattern, INVALID_VISIT_DATE_RANGE.getMessage());

        int vistDate = RequestParser.parseToInt(input);
        ExpectedVisitDateValidator.validateVistDateRange(vistDate);

        return new VisitDate(vistDate);
    }


}
