package chapter02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test // 테스트 메소드로 인식하는 어노테이션
    void plus() {
        int result = Calculator.plus(1,2);
        assertEquals(3, result); // 메소드의 인자로 받은 값이 동일한지 비교, 동일하지 않으면 AssertionFailedError 발생
        assertEquals(5,Calculator.plus(4,1));
    }
}
