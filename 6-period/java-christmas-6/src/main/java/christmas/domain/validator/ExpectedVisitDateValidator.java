package christmas.domain.validator;

import static christmas.constant.ChristmasRule.VISIT_DATE_MAX;
import static christmas.constant.ChristmasRule.VISIT_DATE_MIN;
import static christmas.util.NumberUtils.isBetweenInclusive;

import christmas.constant.ExceptionMessage;


public class ExpectedVisitDateValidator {
    private ExpectedVisitDateValidator() {

    }

    public static void validateVistDateRange(int visitDate) {
        if (!isBetweenInclusive(visitDate, VISIT_DATE_MIN, VISIT_DATE_MAX)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_VISIT_DATE_RANGE.getMessage());
        }
    }
}
