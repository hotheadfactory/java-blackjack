package blackjack.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameParserTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름이 입력이 아예 안됐을 떄")
    void nullInputTest(String input) {
        assertThatThrownBy(() -> NameParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1개 이상");
    }

    @ParameterizedTest
    @DisplayName("입력한 이름으로 파싱 테스트")
    @CsvSource(value = {
            "pobi,jamie,cu:3",
            "포비:1",
            "포비, 제이미, 시카, 코일:4",
            "pobi,jamie,rebecca,hiro,kyle,hodol,geunie,tami:8",
            "@!,#$%,!^&,%&*,알트:5"
    }, delimiter = ':')
    void parseTest(String input, int expected) {
        assertThat(NameParser.parse(input).size()).isEqualTo(expected);
    }
}
