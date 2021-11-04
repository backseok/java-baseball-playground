package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {

    Baseball baseball;

    @BeforeEach
    void setUp() {
        baseball = new Baseball();
    }

    @Test
    void getNumber() {
        for (int i = 0; i < 100; i++) {
            int number = baseball.getNumber();
            assertTrue(number >= 100);
            System.out.println(number);
        }
    }
}