package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.util.CarFactory;
import racingcar.util.RacingCarRandomMoveUtils;
import racingcar.util.RandomUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomUtils racingCarRandomMoveUtils;

    public RacingCarController() {
        inputView = new InputView();
        outputView = new OutputView();
        racingCarRandomMoveUtils = new RacingCarRandomMoveUtils();
    }

    public void startGame() {
        Cars racingCars = createRacingCars();
        TryCount tryCount = inputTryCount();

        racing(racingCars, tryCount);

        outputView.printRacingCarWinnerResult(racingCars);
    }

    private Cars createRacingCars() {
        outputView.printRequestCarNames();
        List<String> splitCarNameList = inputView.inputCarNames();
        return CarFactory.createCars(splitCarNameList);
    }

    private TryCount inputTryCount() {
        outputView.printRequestTryCount();
        String inputTryCount = inputView.inputTryCount();
        return new TryCount(inputTryCount);
    }

    private void racing(Cars cars, TryCount tryCount) {
        outputView.printExecutionResult();
        int totalRound = tryCount.getTryCount();
        for (int race = 0; race < totalRound; race++) {
            cars.moveAll(racingCarRandomMoveUtils);
            outputView.printRoundByExecutionResults(cars);
        }
    }


}
