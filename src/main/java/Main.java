import baseball.v2.Ball;
import baseball.v2.Balls;
import baseball.v2.InputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Balls balls = inputView.createBalls();

        for (Ball ball : balls.getBallList()) {
            System.out.println(ball.getIndex() + "\t" + ball.getNumber());
        }
        System.out.printf();
    }
}
