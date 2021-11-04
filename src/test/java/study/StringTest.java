package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String string1 = "1,2";
        String[] strings1 = string1.split(",");
        String string2 = "1";
        String[] strings2 = string2.split(",");

        assertThat(strings1).contains("1", "2");
        assertThat(strings2).containsExactly("1");
    }

    @Test
    void subString() {
        String string = "(1,2)";
        String substring = string.substring(1, 4);

        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    void charAt() {
        String string = "abc";
        char charAt = string.charAt(1);

        assertThat(charAt).isSameAs('b');
        assertThatThrownBy(() -> string.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
        assertThrows(
                StringIndexOutOfBoundsException.class, () -> string.charAt(3)
        );
    }
}
