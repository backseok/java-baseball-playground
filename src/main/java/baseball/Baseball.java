package baseball;

import java.util.Random;

public class Baseball {

    public int getNumber() {
        Random random = new Random();
        int num = 0;

        for (int i = 0; i < 3; i++) {
            num *= 10;
            num += random.nextInt(9) + 1;
        }
        return num;
    }
}
