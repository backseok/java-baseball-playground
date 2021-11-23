package baseball.v3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<Integer> getNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = scanner.next();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            numbers.add(input.charAt(i) - '0');
        }
        ValidationUtils.validNumberSize(numbers);
        ValidationUtils.validNotSameNumber(numbers);
        return numbers;
    }
}
