package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {
    private Baseball baseball;

    @BeforeEach
    void setUp() {
        baseball = new Baseball();
    }

    @Test
    void setNumber() {
        for (int i = 0; i < 100; i++) {
            baseball.createNumber();
            String number = baseball.createNumber();
            System.out.println(number);
            int[] ints = new int[9];
            for (int j = 0; j < 3; j++) {
                char c = number.charAt(j);
                int num = c - 48;
                ints[num - 1]++;
                assertTrue(num > 0);
                assertTrue(num < 10);
            }

            for (int count : ints) {
                assertTrue(count <= 1);
            }
        }
    }

    @Test
    void play() {
        baseball.play();
    }
}