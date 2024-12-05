package christmas.constant;

public enum ExceptionMessage {
    CANT_NULL_OR_EMPTY("값은 null이거나 비어 있을 수 없습니다."),
    CANT_NULL("값은 null일 수 없습니다"),
    INVALID_INPUT_FORM("유효하지 않은 형식 입니다."),

    INVALID_INTEGER_TYPE("유혀하지 않은 숫자 형식 입니다.");
    //

    NO_EXIST_MENU_MESSAGE("존재하지 않는 메뉴입니다."),
    INVALID_VISIT_DATE_RANGE("유효하지 않은 방문날짜 범위입니다."),
    MENU_CANT_DUPLICATE("메뉴는 중복 될 수 없습니다."),
    MENU_CANT_ONLY_DRINK("음료인 메뉴만 주문할 수 없습니다."),
    INVALID_MENU_QUANTITY_RANGE("메뉴 개수는 1~20 주문 가능합니다."),
    INVALID_MENU_TOTAL_QUANTITY("메뉴 개수는 총 20까지 주문 가능합니다");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = String.format("%s %s %s", "[ERROR]", message, "다시 입력해 주세요.");
    }

    public String getMessage() {
        return message;
    }
}
