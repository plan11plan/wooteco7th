package racingcar.dto;

import java.util.List;

public class RacingResult {
    private final List<RoundResult> roundResults;
    private final List<String> winnerNames;

    public RacingResult(final List<RoundResult> roundResults, final List<String> winnerNames) {
        this.roundResults = roundResults;
        this.winnerNames = winnerNames;
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
