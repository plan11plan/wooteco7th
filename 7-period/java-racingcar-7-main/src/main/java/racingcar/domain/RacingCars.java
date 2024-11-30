package racingcar.domain;

import java.util.List;
import racingcar.util.ListUtil;

public class RacingCars {
    List<RacingCar> racingCars;

    public RacingCars(final List<RacingCar> racingCars) {
        if(1 > racingCars.size() || racingCars.size() > 10){
            throw new IllegalArgumentException("자동차는 1~10대 까지만 참여 가능");
        }
        this.racingCars = racingCars;
    }
}
