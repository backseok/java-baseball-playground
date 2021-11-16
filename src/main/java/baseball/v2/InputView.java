package baseball.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public Balls createBalls() {
        List<int[]> arrayList = new ArrayList<>();
        System.out.print("숫자를 입력해 주세요 : ");
        int numbers = scanner.nextInt();
        for (int i = 2; i >= 0; i--) {
            arrayList.add(new int[]{i, numbers % 10});
            numbers /= 10;
        }
        return new Balls(arrayList);
    }

}
