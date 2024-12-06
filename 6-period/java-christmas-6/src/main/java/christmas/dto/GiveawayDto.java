package christmas.dto;

public class GiveawayDto {
    private final String giveawayName;
    private final int quantity;

    public GiveawayDto(final String giveawayName, final int quantity) {
        this.giveawayName = giveawayName;
        this.quantity = quantity;
    }

    public String getGiveawayName() {
        return giveawayName;
    }

    public int getQuantity() {
        return quantity;
    }
}
