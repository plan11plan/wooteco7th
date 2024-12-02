package racingcar.domain;

public class RacingCar {
    private final RacingCarName name;
    private int moveAmount;

    public RacingCar(final RacingCarName name) {
        this.name = name;
        this.moveAmount = 0;
    }

    private RacingCar(final RacingCarName name, final int moveAmount) {
        this.name = name;
        this.moveAmount = moveAmount;
    }

    public RacingCar move(MovementPolicy movementPolicy) {
        movementPolicy.move(this);
        return new RacingCar(
                name,
                getMoveAmount());
    }

    public void increaseMoveAmount(int value) {
        this.moveAmount += value;
    }

    public void stop() {
    }

    public String getName() {
        return name.getValue();
    }

    public int getMoveAmount() {
        return moveAmount;
    }
}
