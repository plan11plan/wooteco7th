package racingcar.dto;


import java.util.List;

public class RoundResult {
    private final List<MoveResult> moveResults;

    public RoundResult(final List<MoveResult> moveResults) {
        this.moveResults = moveResults;
    }

    public List<MoveResult> getMoveResults() {
        return moveResults;
    }
}

