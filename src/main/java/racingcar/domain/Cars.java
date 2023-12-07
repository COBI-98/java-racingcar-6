package racingcar.domain;

import static racingcar.message.RacingCarErrorMessage.CAR_LIST_EMPTY;
import static racingcar.message.RacingCarErrorMessage.DUPLICATED_CAR_NAME;
import static racingcar.message.RacingCarErrorMessage.NOT_MIN_CAR_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomUtils;

public record Cars(List<Car> cars) {

    private static final int CAR_COUNT_MINIMUM = 2;

    public Cars {
        validateDifferentCarName(cars);
        validateMinimumCountOfCars(cars.size());
    }

    private void validateDifferentCarName(List<Car> cars) {
        long distinctCount = cars.stream()
                .map(idx -> idx.getCarName())
                .distinct()
                .count();

        if (distinctCount != cars.size()) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME.getMessage());
        }
    }

    private void validateMinimumCountOfCars(int size) {
        if (size < CAR_COUNT_MINIMUM) {
            throw new IllegalArgumentException(NOT_MIN_CAR_COUNT.getMessage());
        }
    }

    public void moveAll(final RandomUtils randomUtils) {
        for (final Car car : cars) {
            int engine = randomUtils.generateRandomNumber();
            car.move(engine);
        }
    }

    public List<String> findWinners() {
        Car maxDistanceCar = findMaxDistanceCar();
        List<String> winnerCarNameList = findSameDistanceList(maxDistanceCar);
        return winnerCarNameList;
    }

    private Car findMaxDistanceCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(CAR_LIST_EMPTY.getMessage()));
    }

    private List<String> findSameDistanceList(Car maxDistanceCar) {
        return cars.stream()
                .filter(maxDistanceCar::isSameDistance)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
