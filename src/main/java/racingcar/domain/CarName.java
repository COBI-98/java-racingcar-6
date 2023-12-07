package racingcar.domain;

import static racingcar.message.RacingCarErrorMessage.INVALID_CAR_NAME_LENGTH;

public record CarName(String name) {

    private static final int CAR_NAME_LENGTH_MAX = 5;

    public CarName {
        validateCarNameLengthValidate(name);
    }

    private void validateCarNameLengthValidate(final String carName) {
        if (carName.isEmpty() || carName.length() > CAR_NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }

}