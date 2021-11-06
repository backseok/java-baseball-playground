package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baseball {
    private String answer;
    private String insertAnswer;

    private ResultView resultView = new ResultView();
    private InputView inputView = new InputView();
    private Random random = new Random();

    public void play() {
        int endCheck = 0;
        while (endCheck != 2) {
            createAnswer();
            startGame();
            resultView.printEnd();
            endCheck = inputView.answerReplayGame();
        }
    }

    public void createAnswer() {
        int answer = 0;
        boolean[] check = new boolean[10];
        for (int i = 0; i < 3; i++) {
            int[] ints = duplicateValidAnswer(check, answer, i);
            answer = ints[0];
            i = ints[1];
        }
        this.answer = Integer.toString(answer);
    }

    public void startGame() {
        int strike = 0;
        int ball = 0;
        while (strike != 3) {
            insertAnswer = inputView.insertNum();
            int[] scores = getScores();
            strike = scores[0];
            ball = scores[1];

            resultView.printResult(strike, ball);
        }
    }

    private int[] getScores() {
        int[] ints = new int[2];

        for (int i = 0; i < 3; i++) {
            char answerChar = answer.charAt(i);
            char insertAnswerChar = insertAnswer.charAt(i);

            ints[0] += getStrikeScore(answerChar, insertAnswerChar);
            ints[1] += getBallScore(answerChar, i);
        }

        return ints;
    }

    private int getBallScore(char answerChar, int i) {
        int score = 0;
        List<Integer> indexList = createIndexList(i);
        for (int j = 0; j < 2; j++) {
            score += compareAnswerChar(answerChar, insertAnswer.charAt(indexList.get(j)));
        }
        return score;
    }

    private List<Integer> createIndexList(int i) {
        List<Integer> indexList = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            addIndex(indexList, i, j);
        }
        return indexList;
    }

    private void addIndex(List<Integer> indexList, int i, int j) {
        if (i != j) {
            indexList.add(j);
        }
    }

    private int getStrikeScore(char answerChar, char insertAnswerChar) {
        return compareAnswerChar(answerChar, insertAnswerChar);
    }

    private int compareAnswerChar(char answerChar, char insertAnswerChar) {
        if (answerChar == insertAnswerChar) {
            return 1;
        }
        return 0;
    }

    private int[] duplicateValidAnswer(boolean[] check, int answer, int i) {
        int[] ints = {answer, i};
        int randomNumber = random.nextInt(9) + 1;
        if (check[randomNumber] == true) {
            ints[1]--;
            return ints;
        }
        check[randomNumber] = true;
        ints[0] *= 10;
        ints[0] += randomNumber;
        return ints;
    }

}
