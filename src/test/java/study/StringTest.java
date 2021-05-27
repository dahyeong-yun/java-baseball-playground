package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("replace 문자를 대체할 경우")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("쪼갤 수 있는 것이 있는 경우 split")
    void splitTwoChar() {
        String[] actual = "1,2".split(",");
        String[] expected = {"1", "2"};
        assertThat(actual).contains(expected);
    }

    @Test
    @DisplayName("쪼갤 수 있는 것이 없을 경우 split")
    void splitOneChar() {
        String[] actual = "1".split(",");
        String[] expected = {"1"};
        assertThat(actual).containsExactly(expected);
    }

    @Test
    @DisplayName("subString으로 문자열 자르는 경우")
    void subString() {
        String actual = "(1,2)".substring(1,4);
        String expected = "1,2";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("charAt()의 가능한 인덱스 경우")
    void charAt() {
        char actual = "abc".charAt(1);
        assertThat(actual).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt()의 불가능한 인덱스 경우")
    void charAtOutOfRange() {
        assertThatThrownBy(() -> "abc".charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}