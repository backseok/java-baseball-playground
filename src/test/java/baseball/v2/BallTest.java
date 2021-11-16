package baseball.v2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @Test
    void numberDuplicateValid() {
        for (int i = 0; i < 1000; i++) {
            Balls balls = new Balls();
            List<Ball> ballList = balls.getBallList();

            assertEquals(ballList.size(), 3);
            assertNotEquals(ballList.get(0).getNumber(), ballList.get(1).getNumber());
            assertNotEquals(ballList.get(0).getNumber(), ballList.get(2).getNumber());
            assertNotEquals(ballList.get(1).getNumber(), ballList.get(2).getNumber());
        }
    }

    @Test
    void createBallsWithArrayListParameter() {
        List<int[]> arrayList = new ArrayList<>();
        arrayList.add(new int[]{0, 1});
        arrayList.add(new int[]{1, 2});
        arrayList.add(new int[]{2, 3});

        Balls balls = new Balls(arrayList);
        List<Ball> ballList = balls.getBallList();

        assertEquals(ballList.size(), 3);
    }
}
