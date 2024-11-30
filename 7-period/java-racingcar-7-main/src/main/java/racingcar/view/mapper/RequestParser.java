package racingcar.view.mapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RequestParser {
    private RequestParser() {
    }

    public static List<String> parseRacingCarsInput(String input) {
        List<String> racingCars = Arrays.stream(input.trim().split(",")).toList();
        if(1 > racingCars.size() || racingCars.size() > 10){
            throw new IllegalArgumentException("자동차는 1~10대 까지만 참여 가능");
        }
        return racingCars;
    }

    public static int parserAttemptCount(String input) {
        return Integer.parseInt(input.trim());
    }
    
}
