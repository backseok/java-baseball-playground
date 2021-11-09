package baseball.v2;

public enum BallStatus {
    BALL,
    STRIKE,
    NOTHING;

    public static BallStatus compare(Ball ball1, Ball ball2) {
        if (ball1.getNumber() == ball2.getNumber() && ball1.getIndex() == ball2.getIndex()) {
            return STRIKE;
        }
        if (ball1.getNumber() == ball2.getNumber()) {
            return BALL;
        }
        return NOTHING;
    }
}
