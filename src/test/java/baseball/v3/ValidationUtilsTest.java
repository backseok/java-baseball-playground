package baseball.v3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilsTest {

    @Test
    void validNumber() {
        assertThrows(IllegalStateException.class, () -> ValidationUtils.validNumber(0));
        assertThrows(IllegalStateException.class, () -> ValidationUtils.validNumber(10));
        assertDoesNotThrow(() -> ValidationUtils.validNumber(1));
        assertDoesNotThrow(() -> ValidationUtils.validNumber(9));
    }

//    @Test
//    void validNotSameNumber() {
//        assertThrows(IllegalStateException.class, () -> ValidationUtils.validNotSameNumber(Arrays.asList(1, 1, 1)));
//        assertThrows(IllegalStateException.class, () -> ValidationUtils.validNotSameNumber(Arrays.asList(1, 1, 2)));
//        assertDoesNotThrow(() -> ValidationUtils.validNotSameNumber(Arrays.asList(1, 2, 3)));
//    }

    @Test
    void validNumberSize() {
        assertThrows(IllegalStateException.class, () -> ValidationUtils.validNumberSize(Arrays.asList(1)));
        assertThrows(IllegalStateException.class, () -> ValidationUtils.validNumberSize(Arrays.asList(1, 1)));
        assertDoesNotThrow(() -> ValidationUtils.validNumberSize(Arrays.asList(1, 2, 3)));
    }
}