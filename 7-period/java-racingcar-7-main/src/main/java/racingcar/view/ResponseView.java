package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.RoundResult;

public class ResponseView {
    private final String NEW_LINE = System.lineSeparator();
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String RACE_RESULT = "%s : %s";


    public void printExecutionResult(List<RoundResult> roundResults) {
        System.out.println(NEW_LINE + EXECUTION_RESULT);
        for (RoundResult roundResult : roundResults) {
            roundResult.getMoveResults().stream()
                    .map(moveResult -> toFormat(RACE_RESULT, moveResult.carName(), toDash(moveResult.nowPosition())))
                    .forEach(System.out::println);
            System.out.println();
        }
    }

    public void printWinners(List<String> racingCarNames) {
        String joinedWinners = racingCarNames.stream().collect(Collectors.joining(", "));
        System.out.println(String.format("최종 우승자 : %s", joinedWinners));
    }

    private String toDash(int moveAmount) {
        return "-".repeat(moveAmount);
    }

    private String toFormat(String format, Object... args) {
        return String.format(format, args);
    }
}
