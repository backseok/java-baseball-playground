package baseball;

import java.util.Random;
import java.util.Scanner;

public class Baseball {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public void play() {
        int endCheck = 0;
        while (endCheck != 2) {
            String number = createNumber();
            startGame(number);
            endCheck = answerReplayGame();
        }
    }

    public int answerReplayGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextInt();
    }

    public String createNumber() {
        int number = 0;
        boolean[] booleans = new boolean[9];
        for (int i = 0; i < 3; i++) {
            int randomNumber = random.nextInt(9) + 1;
            if (booleans[randomNumber - 1] == true) {
                i--;
                continue;
            }
            number *= 10;
            number += randomNumber;
        }
        return Integer.toString(number);
    }

    public void startGame(String number) {
        int strike = 0;
        int ball = 0;
        while (strike != 3) {
            String input = insertNum();
            ball = 0;
            strike = 0;

            for (int i = 0; i < 3; i++) {
                char numberChar = number.charAt(i);

                for (int j = 0; j < 3; j++) {
                    char inputChar = input.charAt(j);
                    if (numberChar == inputChar) {
                        if (i == j) {
                            strike++;
                            break;
                        }
                        ball++;
                    }
                }
            }

            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    private String insertNum() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = scanner.next();
        return input;
    }

}
