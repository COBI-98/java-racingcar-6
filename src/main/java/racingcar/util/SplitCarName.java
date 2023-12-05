package racingcar.util;

import static racingcar.message.RacingCarErrorMessage.DUPLICATED_DELIMITER;

import racingcar.message.RacingCarErrorMessage;

public class SplitCarName {

    private static final String SPLIT_DELIMITER = ",";
    private static final String DUPLICATION_DELIMITER_FORMAT = String.format(".*,,.*");

    public static String[] splitCarNames(String input) {
        validateDuplicateDelimiter(input);
        return input.split(SPLIT_DELIMITER);
    }

    private static void validateDuplicateDelimiter(String input) {
        boolean hasConsecutiveDelimiters = input.matches(DUPLICATION_DELIMITER_FORMAT);
        
        if (hasConsecutiveDelimiters) {
            throw new IllegalArgumentException(DUPLICATED_DELIMITER.getMessage());
        }
    }
}
