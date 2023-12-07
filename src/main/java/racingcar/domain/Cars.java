package racingcar.domain;

import static racingcar.message.RacingCarErrorMessage.INVALID_CARS_EMPTY;
import static racingcar.message.RacingCarErrorMessage.INVALID_DUPLICATION_CAR_NAME;
import static racingcar.message.RacingCarErrorMessage.INVALID_MINIMUM_CARS_COUNT;

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
            throw new IllegalArgumentException(INVALID_DUPLICATION_CAR_NAME.getMessage());
        }
    }

    private void validateMinimumCountOfCars(int size) {
        if (size < CAR_COUNT_MINIMUM) {
            throw new IllegalArgumentException(INVALID_MINIMUM_CARS_COUNT.getMessage());
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
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CARS_EMPTY.getMessage()));
    }

    private List<String> findSameDistanceList(Car maxDistanceCar) {
        return cars.stream()
                .filter(maxDistanceCar::isSameDistance)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
