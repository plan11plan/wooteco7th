package christmas.dto;

public class BenefitDetail {
    private final String name;
    private final int discountAmount;

    public BenefitDetail(final String name, final int discountAmount) {
        this.name = name;
        this.discountAmount = discountAmount;
    }

    public String getName() {
        return name;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
