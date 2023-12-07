package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarFactory {

    private static final int START_LOCATION = 0;

    public static Cars createCars(final List<String> carNames) {
        List<Car> cars = makeCars(carNames);
        return new Cars(cars);
    }

    private static List<Car> makeCars(final List<String> carNames) {

        return carNames.stream()
                .map(CarFactory::makeCar)
                .collect(Collectors.toList());
    }

    private static Car makeCar(final String carName) {
        return new Car(carName, START_LOCATION);
    }
}
