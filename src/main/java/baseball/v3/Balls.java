package baseball.v3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Balls {
    private List<Ball> answers = new ArrayList<>();

    public static Balls createAnswer() {
        List<Integer> numbers = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            int randomNumber = r.nextInt(9) + 1 ;
            if (!ValidationUtils.validNotSameNumber(randomNumber, numbers)) {
                i--;
                continue;
            }
            numbers.add(randomNumber);
        }
        return new Balls(numbers);
    }

    public Balls(List<Integer> numbers) {
        for (int i = 0; i < 3; i++) {
            answers.add(new Ball(i + 1, numbers.get(i)));
        }
    }

    public PlayResult play(List<Integer> numbers) {
        PlayResult result = new PlayResult();
        for (Ball answer : answers) {
            for (int i = 0; i < 3; i++) {
                Ball ball = new Ball(i + 1, numbers.get(i));
                result.addScore(answer.play(ball));
            }
        }
         return result;
    }

    public PlayResult play(Ball ball) {
        PlayResult result = new PlayResult();
        for (Ball answer : answers) {
            result.addScore(answer.play(ball));
        }
        return result;
    }

    public List<Ball> getAnswers() {
        return answers;
    }
}
