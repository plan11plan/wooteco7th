package racingcar.domain;

import static racingcar.util.NumberUtil.isBetweenInclusive;

public class AttemptCount {
    private final int value;

    public AttemptCount(final int value) {
        if (!isBetweenInclusive(value, 1, 10)) {
            throw new IllegalArgumentException("1~10 시도 횟수만 가능");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
