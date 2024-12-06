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

    private final String displayName;
    private final int price;

    Badge(final String displayName, final int price) {
        this.displayName = displayName;
        this.price = price;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getPrice() {
        return price;
    }
}
