package racingcar.view;

import static racingcar.util.UtilSign.COLON;
import static racingcar.util.UtilSign.COMMA;
import static racingcar.util.UtilSign.MOVE;
import static racingcar.util.UtilSign.NEW_LINE;
import static racingcar.util.UtilSign.SPACE;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자";

    public void printRequestCarNames() {
        System.out.println(INPUT_CAR_NAMES);
    }

    public void printRequestTryCount() {
        System.out.println(INPUT_TRY_COUNT);
    }

    public void printExecutionResult() {
        System.out.println(NEW_LINE.getTitle() + EXECUTION_RESULT);
    }

    public void printRoundByExecutionResults(final Cars cars) {
        StringBuilder resultByRound = new StringBuilder();
        for (final Car car : cars.cars()) {
            resultByRound.append(car.getCarName())
                    .append(COLON.getTitle())
                    .append(MOVE.getTitle().repeat(car.getDistance()))
                    .append(NEW_LINE.getTitle());
        }
        System.out.println(resultByRound);
    }

    public void printRacingCarWinnerResult(final Cars cars) {
        List<String> winners = cars.findWinners();
        StringBuilder winnerRacingCar = new StringBuilder();
        winnerRacingCar.append(FINAL_WINNER)
                .append(COLON.getTitle())
                .append(joiningNames(winners));

        System.out.println(winnerRacingCar);
    }

    private static String joiningNames(List<String> winners) {
        return winners.stream()
                .collect(Collectors.joining(
                        COMMA.getTitle()
                        + SPACE.getTitle())
                );
    }

}
