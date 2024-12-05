package christmas.constant;

public enum ExceptionMessage {
    NULL_OR_EMPTY_MESSAGE("값은 null이거나 비어 있을 수 없습니다."),
    INVALID_FORMAT_MESSAGE("유효하지 않은 형식 입니다."),
    //
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
