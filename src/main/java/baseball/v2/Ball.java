package baseball.v2;

public class Ball {
    private int index;
    private int number;

    public Ball(int index, int number) {
        this.index = index;
        this.number = number;
    }

    public BallStatus play(Ball answerBall) {
        return BallStatus.compare(this, answerBall);
    }

    public int getIndex() {
        return index;
    }

    public int getNumber() {
        return number;
    }
}
