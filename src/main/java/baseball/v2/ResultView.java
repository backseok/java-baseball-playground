package baseball.v2;

public class ResultView {

    public void printScore(int strikeScore, int ballScore) {
        if (strikeScore == 0 && ballScore == 0) {
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

    public void gameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
