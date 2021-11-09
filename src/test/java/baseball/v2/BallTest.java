package baseball.v2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.v2.BallStatus.*;
import static org.junit.jupiter.api.Assertions.*;

public class BallTest {

    @Test
    void strike() {
        Ball ball = new Ball(0, 1);
        Ball answerBall = new Ball(0, 1);

        assertEquals(ball.play(answerBall), STRIKE);
    }

    @Test
    void ball() {
        Ball ball = new Ball(0, 1);
        Ball answerBall = new Ball(1, 1);

        assertEquals(ball.play(answerBall), BALL);
    }

    @Test
    void nothing() {
        Ball ball = new Ball(0, 1);
        Ball answerBall = new Ball(0, 8);

        assertEquals(ball.play(answerBall), NOTHING);
    }
}
