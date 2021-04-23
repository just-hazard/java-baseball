package baseball.domain;

import baseball.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberTest {

    Number number;

    @ParameterizedTest
    @CsvSource(value = {"0","10"})
    @DisplayName("1-9 범위 검증")
    void number_check(int inputNumber) {
        assertThrows(IllegalArgumentException.class, () -> {
            number = new Number(inputNumber);
        });
    }
}
