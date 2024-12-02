package racingcar.domain;

import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.MoveResult;
import racingcar.dto.RacingResult;
import racingcar.dto.RoundResult;

public class RacingCars {
    private final List<RacingCar> racingCars;
    private final MovementPolicy movementPolicy;

    public RacingCars(final List<RacingCar> racingCars, final MovementPolicy movementPolicy) {
        this.racingCars = racingCars;
        this.movementPolicy = movementPolicy;
    }

    // TODO : 모든 자동차를 움직인 이후, 결과 상태를 DTO로 매핑해서 -> 움직인 결과를 반환 해야 하는 상황
    public RacingResult race(AttemptCount attemptCount) {
        List<RoundResult> allRoundResult = new ArrayList<>();
        List<RacingCar> currentCars = new ArrayList<>(racingCars);

        for (int i = 0; i < attemptCount.getValue(); i++) {
            List<MoveResult> moveResults = currentCars.stream()
                    .map(car -> car.move(movementPolicy))
                    .map(movedCar -> new MoveResult(movedCar.getName(), movedCar.getMoveAmount()))
                    .toList();

            allRoundResult.add(new RoundResult(moveResults));
        }
        int maxAmount = currentCars.stream().mapToInt(racedCar -> racedCar.getMoveAmount())
                .max()
                .getAsInt();

        List<String> winnerNames = currentCars.stream()
                .filter(racedCar -> racedCar.getMoveAmount() == maxAmount)
                .map(RacingCar::getName)
                .collect(Collectors.toList());

        return new RacingResult(allRoundResult, winnerNames);
    }

}
