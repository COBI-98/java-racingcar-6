package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

class CarFactoryTest {

    @DisplayName("경주할 자동차를 출발선에 생성한다.")
    @Test
    void createCarToStartingLine() throws Exception {
        //given
        List<String> carNames = List.of("pobi", "woni", "jun");

        //when
        Cars cars = CarFactory.createCars(carNames);

        //then
        assertThat(cars.cars())
                .extracting("CarName", "Distance")
                .containsExactlyInAnyOrder(
                        tuple("pobi", 0),
                        tuple("woni", 0),
                        tuple("jun", 0)
                );
    }
}