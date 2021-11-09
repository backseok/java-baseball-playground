package baseball.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public Balls getAnswer() {
        System.out.print("숫자를 입력해 주세요 : ");
        String numbers = scanner.next();
        List<Integer> numberList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            numberList.add(numbers.charAt(i) - '0');
        }
        return new Balls(numberList);
    }

    public boolean answerRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int check = scanner.nextInt();
        if (check == 1) {
            return true;
        }
        return false;
    }
}
