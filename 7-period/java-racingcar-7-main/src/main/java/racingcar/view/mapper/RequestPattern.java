package racingcar.view.mapper;

import racingcar.view.mapper.PatternBuilder.DataType;

public class RequestPattern {
    private RequestPattern() {
    }

    public static String createRacingCars() {
        return new PatternBuilder()
                .setItemDelimiter(",")
                .addDataType(DataType.STRING)
                .build();
    }

    public static String createAttemptCount() {
        return new PatternBuilder()
                .addDataType(DataType.POSITIVE_INTEGER)
                .build();
    }

}
