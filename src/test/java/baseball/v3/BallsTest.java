package baseball.v3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class BallsTest {

    Balls balls;

    @BeforeEach
    void before() {
        balls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void nothing() {
        PlayResult result = balls.play(new Ball(1, 4));

        assertThat(result.isNothing()).isTrue();
        assertEquals(result.getStrike(), 0);
        assertEquals(result.getBall(), 0);
    }

    @Test
    void nothing2() {
        PlayResult result = balls.play(Arrays.asList(4, 5, 6));

        assertThat(result.isNothing()).isTrue();
        assertEquals(result.getStrike(), 0);
        assertEquals(result.getBall(), 0);
    }

    @Test
    void ball() {
        PlayResult result = balls.play(new Ball(1, 3));

        assertEquals(result.getStrike(), 0);
        assertEquals(result.getBall(), 1);
    }

    @Test
    void ball2() {
        PlayResult result = balls.play(Arrays.asList(3, 1, 2));

        assertThat(result.isNothing()).isFalse();
        assertEquals(result.getStrike(), 0);
        assertEquals(result.getBall(), 3);
    }

    @Test
    void strike() {
        PlayResult result = balls.play(new Ball(1, 1));

        assertEquals(result.getStrike(), 1);
        assertEquals(result.getBall(), 0);
    }

    @Test
    void strike2() {
        PlayResult result = balls.play(Arrays.asList(1, 2, 3));

        assertThat(result.isNothing()).isFalse();
        assertEquals(result.getStrike(), 3);
        assertEquals(result.getBall(), 0);
    }

    @Test
    void createAnswer() {
        for (int i = 0; i < 100; i++) {
            Balls answer = Balls.createAnswer();
            List<Ball> answers = answer.getAnswers();
            for (int j = 0; j < 3; j++) {
                int number = answers.get(j).getNumber();
                System.out.print(number);
                for (int k = 0; k < 3; k++) {
                    assertThat(j != k && number == answers.get(k).getNumber()).isFalse();
                }
            }
            System.out.println();
        }
    }
}
