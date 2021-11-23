package baseball.v3;

import java.util.Scanner;

public class ResultView {
    private static Scanner scanner = new Scanner(System.in);

    public static void printResult(PlayResult result) {
        if (result.isNothing()) {
            System.out.println("낫싱");
            return;
        }
        if (result.noBall()) {
            System.out.println(result.getStrike() + "스트라이크");
            return;
        }
        if (result.noStrike()) {
            System.out.println(result.getBall() + "볼");
            return;
        }
        System.out.println(result.getBall() + "볼 " + result.getStrike() + "스트라이크");
    }

    public static void gameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextInt() == 1;
    }
}
