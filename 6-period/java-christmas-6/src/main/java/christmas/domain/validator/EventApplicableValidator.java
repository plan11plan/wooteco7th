package christmas.domain.validator;

import static christmas.constant.ChristmasRule.CRITERIA_OF_EVENT_APPLICABLE;


public class EventApplicableValidator {
    private EventApplicableValidator() {
    }

    public static boolean canApplyEvent(int totalBuyAmount) {
        if (totalBuyAmount >= CRITERIA_OF_EVENT_APPLICABLE) {
            return true;
        }
        return false;

    }
}
