package calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void testSqrt() {
        assertEquals(4.0, calc.sqrt(16), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> calc.sqrt(-1));
    }

    @Test
    void testFactorial() {
        assertEquals(720, calc.factorial(6));
        assertEquals(1, calc.factorial(0));
        assertThrows(IllegalArgumentException.class, () -> calc.factorial(-3));
    }

    @Test
    void testLn() {
        assertEquals(0.0, calc.ln(1), 0.0001);
        assertThrows(IllegalArgumentException.class, () -> calc.ln(0));
    }

    @Test
    void testPower() {
        assertEquals(8.0, calc.power(2, 3), 0.0001);
        assertEquals(1.0, calc.power(5, 0), 0.0001);
    }
}
