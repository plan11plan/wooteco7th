package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import racingcar.domain.AttemptCount;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.view.mapper.ModelMapper;

public class RequestView {
    private final String INPUT_RACING_CAR_NAMES= "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private final String NUMBER_OF_ATTEMPTS_MESSAGE = "시도할 횟수는 몇 회인가요?";


    public static void main(String[] args) {
        RequestView requestView = new RequestView();
        List<RacingCar> racingCars = requestView.requestRacingCars();
        racingCars.forEach(System.out::println);
        System.out.println();
        AttemptCount attemptCount = requestView.requestAttemptCount();
        System.out.println(attemptCount.getValue());

        RacingCars racingCars1 = new RacingCars(racingCars);
        System.out.println(racingCars1.toString());

    }
    public List<RacingCar> requestRacingCars() {
        return request(INPUT_RACING_CAR_NAMES, ModelMapper::toRacingCars);
    }

    public AttemptCount requestAttemptCount() {
        return request(NUMBER_OF_ATTEMPTS_MESSAGE, ModelMapper::toAttemptCount);
    }

    private <T> T request(String message, Function<String, T> mapper) {
        return retryOnException(() -> {
            System.out.println(message);
            String input = Console.readLine();
            return mapper.apply(input);
        });
    }

    private <T> T retryOnException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
