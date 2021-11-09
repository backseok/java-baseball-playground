package baseball.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Balls {
    private List<Ball> ballList = new ArrayList<>();
    private ResultView resultView = new ResultView();
    private InputView inputView = new InputView();

    public void play() {
        boolean check = true;
        while (check) {
            ballList = createBallList();
            startGame();
            resultView.gameOver();
            check = inputView.answerRestart();
        }
    }

    private void startGame() {
        int strikeScore = 0;
        int ballScore = 0;
        while (strikeScore != 3) {
            Balls answer = inputView.getAnswer();
            ResultScore resultScore = new ResultScore(this, answer);
            strikeScore = resultScore.getStrikeScore();
            ballScore = resultScore.getBallScore();
            resultView.printScore(strikeScore, ballScore);
        }
    }

    public List<Ball> createBallList() {
        List<Ball> ballList = new ArrayList<>();
        Random r = new Random();

        while (ballList.size() != 3) {
            int randomNumber = r.nextInt(8) + 1;
            List<Integer> numbers = createNumberList(ballList);
            numberDuplicateValid(randomNumber, numbers, ballList);
        }
        return ballList;
    }

    private void numberDuplicateValid(int randomNumber, List<Integer> numbers, List<Ball> ballList) {
        if (numbers.contains(randomNumber)) {
            return;
        }
        ballList.add(new Ball(ballList.size(), randomNumber));
    }

    private List<Integer> createNumberList(List<Ball> ballList) {
        List<Integer> numbers = new ArrayList<>();
        for (Ball ball : ballList) {
            numbers.add(ball.getNumber());
        }
        return numbers;
    }

    public List<Ball> getBallList() {
        return ballList;
    }

    public Balls(List<Integer> numberList) {
        ballList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ballList.add(new Ball(i, numberList.get(i)));
        }
    }

    public Balls() {
    }
}
