import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calculator() {
        Calculator calculator = new Calculator();
        double result1 = calculator.calculate("2 + 3 * 4 / 2");
        double result2 = calculator.calculate("21 * 3 * 4 / 9");

        assertEquals(result1, 10);
        assertEquals(result2, 28);
    }

}