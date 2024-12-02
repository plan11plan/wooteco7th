package racingcar.view.mapper;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.AttemptCount;
import racingcar.domain.RacingCarName;

public class ModelMapper {
    private static final String PRODUCT_ERROR_MESSAGE = "[ERROR] 올바르지 않은 형식입니다. '[상품명,가격,수량]' 형식으로 입력해주세요.";
    private static final String VISIT_DAY_ERROR_MESSAGE = "[ERROR] 1 이상의 숫자를 입력해주세요.";

    private ModelMapper() {
    }

    public static List<RacingCarName> toRacingCarNames(String input) {
        String pattern = RequestPattern.createRacingCars();
        RequestValidator.validateInput(input, pattern, PRODUCT_ERROR_MESSAGE);

        return RequestParser.parseRacingCarsInput(input)
                .stream().map(name -> new RacingCarName(name))
                .collect(Collectors.toList());
    }

    public static AttemptCount toAttemptCount(String input) {
        String pattern = RequestPattern.createAttemptCount();
        RequestValidator.validateInput(input, pattern, VISIT_DAY_ERROR_MESSAGE);

        int attemptCount = RequestParser.parserAttemptCount(input);
        return new AttemptCount(attemptCount);
    }
} 
