package christmas.constant;

public enum MenuType {
    APPATIZER("에피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    DRINK("음료");


    private final String name;

    MenuType(final String name) {
        this.name = name;
    }
}
