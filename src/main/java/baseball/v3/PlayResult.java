package baseball.v3;

import static baseball.v3.BallStatus.*;

public class PlayResult {
    private int strike;
    private int ball;

    public void addScore(BallStatus status) {
        if (status.isStrike()) {
            strike++;
        }
        if (status.isBall()) {
            ball++;
        }
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isGameEnd() {
        return strike == 3;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean noStrike() {
        return strike == 0;
    }

    public boolean noBall() {
        return ball == 0;
    }
}
