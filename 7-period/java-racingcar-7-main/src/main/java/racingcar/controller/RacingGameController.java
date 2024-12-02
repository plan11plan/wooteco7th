package racingcar.controller;

import java.util.List;
import racingcar.domain.AttemptCount;
import racingcar.domain.MovementPolicy;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarName;
import racingcar.domain.RandomNumberGenerator;
import racingcar.dto.RacingResult;
import racingcar.service.RacingGameService;
import racingcar.view.RequestView;
import racingcar.view.ResponseView;

public class RacingGameController {
    private final RequestView requestView;
    private final RacingGameService service;
    private final ResponseView responseView;

    public RacingGameController() {
        this.requestView = new RequestView();
        this.service = new RacingGameService(new MovementPolicy(new RandomNumberGenerator()));
        this.responseView = new ResponseView();
    }

    public void run() {
        List<RacingCarName> racingCarNames = requestView.requestRacingCarNames();
        List<RacingCar> racingCars = service.createCars(racingCarNames);

        AttemptCount attemptCount = requestView.requestAttemptCount();
        RacingResult racingResult = service.race(racingCars, attemptCount);

        responseView.printExecutionResult(racingResult.getRoundResults());
        responseView.printWinners(racingResult.getWinnerNames());

    }
}
