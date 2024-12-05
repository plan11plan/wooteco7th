package christmas.constant;

/*
5천 원 이상:별

        1만 원 이상:트리

        2만 원 이상:산타
 */
public enum Badge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000);

    private final String name;
    private final int price;

    Badge(final String name, final int price) {
        this.name = name;
        this.price = price;
    }
}
