package racingcar.domain;

import racingcar.util.StringUtil;

public class RacingCar {
    private final String name;

    public RacingCar(final String name) {
        if(!StringUtil.isBetweenLength(name,1,5)){
            throw new IllegalArgumentException("자동차 이름은 1~5글자 까지만 가능");
        }
        this.name = name;
    }
}
