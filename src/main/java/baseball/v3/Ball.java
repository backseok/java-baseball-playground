package baseball.v3;

import java.util.Objects;

import static baseball.v3.BallStatus.*;

public class Ball {
    private final int position;
    private final int number;

    public Ball(int position, int number) {
        ValidationUtils.validNumber(number);
        this.position = position;
        this.number = number;
    }

    public BallStatus play(Ball ball) {
        if (equals(ball)) {
            return STRIKE;
        }
        if (sameNumber(ball)) {
            return BALL;
        }
        return NOTHING;
    }

    private boolean sameNumber(Ball ball) {
        return number == ball.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }

    public int getNumber() {
        return number;
    }
}
