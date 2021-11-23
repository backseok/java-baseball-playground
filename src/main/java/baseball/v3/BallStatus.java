package baseball.v3;

public enum BallStatus {
    NOTHING, BALL, STRIKE;

    public boolean isNothing() {
        return this == NOTHING;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
