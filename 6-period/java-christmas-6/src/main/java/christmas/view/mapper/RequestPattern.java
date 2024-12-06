package christmas.view.mapper;

import christmas.view.mapper.PatternBuilder.DataType;

public class RequestPattern {
    private RequestPattern() {
    }

    public static String createVisitDatePattern() {
        return new PatternBuilder()
                .addDataType(DataType.POSITIVE_INTEGER)
                .build();
    }

    public static String createOrderMenusPattern() {
        return new PatternBuilder()
                .setItemDelimiter(",")
                .setDataDelimiter("-")
                .addDataType(DataType.STRING)
                .addDataType(DataType.POSITIVE_INTEGER)
                .build();
    }


}
