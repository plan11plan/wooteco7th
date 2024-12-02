package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.AttemptCount;
import racingcar.domain.MovementPolicy;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarName;
import racingcar.domain.RacingCars;
import racingcar.dto.RacingResult;

public class RacingGameService {
    private final MovementPolicy movementPolicy;

    public RacingGameService(final MovementPolicy movementPolicy) {
        this.movementPolicy = movementPolicy;
    }


    public List<RacingCar> createCars(final List<RacingCarName> racingCarNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (RacingCarName name : racingCarNames) {
            RacingCar racingCar = new RacingCar(name);
            racingCars.add(racingCar);
        }
        if (1 > racingCars.size() || racingCars.size() > 10) {
            throw new IllegalArgumentException("자동차는 1~10대 까지만 참여 가능");
        }

        return racingCars;

    }

    public RacingResult race(List<RacingCar> racingCars, final AttemptCount attemptCount) {
        return new RacingCars(racingCars, movementPolicy)
                .race(attemptCount);
    }
}
