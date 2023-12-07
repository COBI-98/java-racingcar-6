package racingcar.util;

import static racingcar.message.RacingCarErrorMessage.INVALID_DUPLICATED_DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitCarName {

    private static final String SPLIT_DELIMITER = ",";
    private static final String DUPLICATION_DELIMITER_FORMAT = String.format(".*,,.*");

    public static List<String> splitCarNames(final String input) {
        validateDuplicateDelimiter(input);
        return Arrays.stream(input.split(SPLIT_DELIMITER))
                .collect(Collectors.toList());
    }

    private static void validateDuplicateDelimiter(final String input) {
        boolean hasConsecutiveDelimiters = input.matches(DUPLICATION_DELIMITER_FORMAT);
        
        if (hasConsecutiveDelimiters) {
            throw new IllegalArgumentException(INVALID_DUPLICATED_DELIMITER.getMessage());
        }
    }
}
