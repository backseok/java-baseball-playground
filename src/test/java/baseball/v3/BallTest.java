package baseball.v3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BallTest {
    Ball ball;

    @BeforeEach
    void before() {
        ball = new Ball(1, 1);
    }

    @Test
    void Nothing() {
        assertEquals(ball.play(new Ball(1, 3)), BallStatus.NOTHING);
    }

    @Test
    void Ball() {
        assertEquals(ball.play(new Ball(2, 1)), BallStatus.BALL);
    }

    @Test
    void strike() {
        assertEquals(ball.play(new Ball(1, 1)), BallStatus.STRIKE);
    }
}
