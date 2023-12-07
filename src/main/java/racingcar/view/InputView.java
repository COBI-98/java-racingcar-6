package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.util.SplitCarName;

public class InputView {

    public List<String> inputCarNames() {
        String carNames = Console.readLine();
        return SplitCarName.splitCarNames(carNames);
    }

    public String inputTryCount() {
        return Console.readLine();
    }
}
