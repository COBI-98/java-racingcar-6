package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SplitCarNameTest {

    @DisplayName("constructor() : 자동차는 쉼표(,)를 기준으로 구분하여 생성된다.")
    @Test
    void splitCarName_constructor_success() throws Exception {
        //given
        String playerInput = "pobi,woni,jun,cobi";
        List<String> splitCarNameList = SplitCarName.splitCarNames(playerInput);

        //when //then
        assertThat(splitCarNameList).hasSize(4)
                .containsExactlyInAnyOrder(
                        "pobi",
                        "woni",
                        "jun",
                        "cobi"
                );
    }

    @DisplayName("validateDuplicateDelimiter() : 연속된 구분자가 사용되는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,,,jun,cobi","pobi,woni,,,,,,,,,"})
    void validateDuplicateDelimiter_fail(String playerInput) throws Exception {
        //given
        String exceptionMessage = "중복으로 구분자를 사용할 수 없습니다.";

        //when //then
        assertThatThrownBy(() -> SplitCarName.splitCarNames(playerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(exceptionMessage);
    }
}