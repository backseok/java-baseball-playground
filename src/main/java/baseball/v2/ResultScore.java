package baseball.v2;

import static baseball.v2.BallStatus.*;

public class ResultScore {
    private int strikeScore;
    private int ballScore;

    public ResultScore(Balls balls, Balls answer) {
        for (Ball ball : balls.getBallList()) {
            for (Ball answerBall : answer.getBallList()) {
                BallStatus status = ball.play(answerBall);
                if (status == STRIKE) {
                    strikeScore++;
                }
                if (status == BALL) {
                    ballScore++;
                }
            }
        }
    }

    public int getStrikeScore() {
        return strikeScore;
    }

    public int getBallScore() {
        return ballScore;
    }
}
