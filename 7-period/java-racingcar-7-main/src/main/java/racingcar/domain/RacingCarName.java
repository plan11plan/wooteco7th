package racingcar.domain;

import racingcar.util.StringUtil;

public class RacingCarName {
    private final String value;

    public RacingCarName(final String value) {
        if (!StringUtil.isBetweenLength(value, 1, 5)) {
            throw new IllegalArgumentException("자동차 이름은 1~5글자 까지만 가능");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
