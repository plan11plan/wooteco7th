package racingcar.domain;

public class MovementPolicy {
    private final RandomNumberGenerator numberGenerator;

    public MovementPolicy(final RandomNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void move(final RacingCar racingCar) {
        int generateNum = numberGenerator.generate();
        if(4 <= generateNum && generateNum <= 9){
            racingCar.increaseMoveAmount(1);
        }
        racingCar.stop();
    }
}
