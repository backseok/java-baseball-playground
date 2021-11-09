package baseball.v2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BallsTest {

    @Test
    void 숫자_중복_확인() {
        for (int i = 0; i < 1000; i++) {
            Balls balls = new Balls();
            List<Ball> ballList = balls.createBallList();

            assertEquals(ballList.size(), 3);
            assertNotEquals(ballList.get(0).getNumber(), ballList.get(1).getNumber());
            assertNotEquals(ballList.get(0).getNumber(), ballList.get(2).getNumber());
            assertNotEquals(ballList.get(1).getNumber(), ballList.get(2).getNumber());
        }
    }

    @Test
    void createBallsWithArrayListParameter() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        Balls balls = new Balls(numbers);
        List<Ball> ballList = balls.getBallList();

        assertEquals(ballList.size(), 3);
    }

    @Test
    void resultScore() {
        ResultScore resultScore1 = new ResultScore(new Balls(Arrays.asList(1, 2, 3)), new Balls(Arrays.asList(1, 2, 3)));
        ResultScore resultScore2 = new ResultScore(new Balls(Arrays.asList(1, 2, 3)), new Balls(Arrays.asList(3, 1, 2)));
        ResultScore resultScore3 = new ResultScore(new Balls(Arrays.asList(1, 2, 3)), new Balls(Arrays.asList(4, 5, 6)));
        ResultScore resultScore4 = new ResultScore(new Balls(Arrays.asList(1, 2, 3)), new Balls(Arrays.asList(1, 3, 2)));

//        3Strike
        assertEquals(resultScore1.getStrikeScore(), 3);
        assertEquals(resultScore1.getBallScore(), 0);
//        3Ball
        assertEquals(resultScore2.getStrikeScore(), 0);
        assertEquals(resultScore2.getBallScore(), 3);
//        Nothing
        assertEquals(resultScore3.getStrikeScore(), 0);
        assertEquals(resultScore3.getBallScore(), 0);
//        1Strike 2Ball
        assertEquals(resultScore4.getStrikeScore(), 1);
        assertEquals(resultScore4.getBallScore(), 2);
    }
}