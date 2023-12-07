package racingcar.domain;

import static racingcar.message.RacingCarErrorMessage.INVALID_TRY_COUNT_NATURAL_NUMBER;

public class TryCount {

    private final int tryCount;

    public TryCount(final String tryCount) {
        validateNaturalNumber(tryCount);
        this.tryCount = convertStringToInt(tryCount);
    }

    private void validateNaturalNumber(final String tryCount) {
        if (!tryCount.matches("^[1-9]\\d*$")){
            throw new IllegalArgumentException(INVALID_TRY_COUNT_NATURAL_NUMBER.getMessage());
        }
    }

    private int convertStringToInt(final String input) {
        return Integer.parseInt(input);
    }

    public int getTryCount() {
        return tryCount;
    }
}
