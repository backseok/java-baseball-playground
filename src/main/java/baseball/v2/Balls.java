package baseball.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static baseball.v2.BallStatus.*;

public class Balls {
    private List<Ball> ballList;
    private int strikeScore;
    private int ballScore;
    private int restartAnswer;
//    private ResultView resultView;
    private InputView inputView;

    public void play(Balls answer) {
        while (restartAnswer != 2) {
            while (strikeScore != 3) {
                for (Ball ball : this.getBallList()) {
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

                if (ballScore == 0 && strikeScore == 0) {
                    System.out.println("낫싱");
                    return;
                }
                if (strikeScore != 0 && ballScore != 0) {
                    System.out.println(ballScore + "볼 " + strikeScore + "스트라이크");
                    return;
                }
                if (strikeScore != 0) {
                    System.out.println(strikeScore + "스트라이크");
                    return;
                }
                System.out.println(ballScore + "볼");
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    public Balls() {
        ballList = new ArrayList<>();
        Random r = new Random();

        while (ballList.size() != 3) {
            int randomNumber = r.nextInt(8) + 1;
            List<Integer> numbers = createNumberList();
            numberDuplicateValid(randomNumber, numbers);
        }
    }

    public Balls(List<int[]> arrayList) {
        ballList = new ArrayList<>();
        for (int[] ints : arrayList) {
            System.out.println(ints[0]);
            ballList.add(new Ball(ints[0], ints[1]));
        }
    }

    private void numberDuplicateValid(int randomNumber, List<Integer> numbers) {
        if (numbers.contains(randomNumber)) {
            return;
        }
        ballList.add(new Ball(ballList.size() - 1, randomNumber));
    }

    private List<Integer> createNumberList() {
        List<Integer> numbers = new ArrayList<>();
        for (Ball ball : ballList) {
            numbers.add(ball.getNumber());
        }
        return numbers;
    }

    public List<Ball> getBallList() {
        return ballList;
    }

}
