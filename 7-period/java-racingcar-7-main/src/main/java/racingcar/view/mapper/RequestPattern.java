package racingcar.view.mapper;

import racingcar.view.mapper.PatternBuilder.DataType;

public class RequestPattern {
    private RequestPattern() {
    }

    public static String createRacingCars() {

        String regrxSting = new PatternBuilder()
                .setWrapper("[", "]")
                .setItemDelimiter(",")
                .setItemDelimiter("-")
                .addDataType(DataType.STRING)
                .addDataType(DataType.INTEGER)
                .build();

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
