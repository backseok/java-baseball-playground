package baseball.v3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        do {
            Balls answer = Balls.createAnswer();
            PlayResult result = new PlayResult();
            while (!result.isGameEnd()) {
                List<Integer> numbers = InputView.getNumbers();
                result = answer.play(numbers);
                ResultView.printResult(result);
            }
            ResultView.gameEnd();
        } while (ResultView.restart());
    }
}
