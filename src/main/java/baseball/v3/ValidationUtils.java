package baseball.v3;

import java.util.List;

public class ValidationUtils {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    public static void validNumber(int number) {
        if (MIN_NUMBER > number || number > MAX_NUMBER) {
            throw new IllegalStateException("숫자의 범위는 1~9를 벗어날 수 없습니다.");
        }
    }

    public static void validNumberSize(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalStateException("3개의 숫자를 입력해야 합니다.");
        }
    }

    public static boolean validNotSameNumber(List<Integer> numbers) {
        if (isSameNumber(numbers)) {
            return false;
//            throw new IllegalStateException("숫자는 서로 다른 수로 이루어져 있어야 합니다.");
        }
        return true;
    }

    public static boolean validNotSameNumber(int randomNumber, List<Integer> numbers) {
        if (isSameNumber(randomNumber, numbers)) {
            return false;
//            throw new IllegalStateException("숫자는 서로 다른 수로 이루어져 있어야 합니다.");
        }
        return true;
    }

    private static boolean isSameNumber(List<Integer> numbers) {
        return numbers.get(0) == numbers.get(1) || numbers.get(0) == numbers.get(2) || numbers.get(1) == numbers.get(2);
    }

    private static boolean isSameNumber(int randomNumber, List<Integer> numbers) {
        for (Integer number : numbers) {
            if (randomNumber == number) {
                return true;
            }
        }
        return false;
    }
}
