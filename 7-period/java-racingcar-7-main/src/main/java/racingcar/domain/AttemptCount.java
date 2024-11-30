package racingcar.domain;

import static racingcar.util.NumberUtil.*;

import racingcar.util.NumberUtil;

public class AttemptCount {
    private final int value;

    public AttemptCount(final int value) {
        if(!isBetweenInclusive(value,1,5)){
            throw new IllegalArgumentException("1~5 시도 횟수만 가능");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
