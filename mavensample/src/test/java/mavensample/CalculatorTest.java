package mavensample;



import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;
    private static final double DELTA = 0.0001; 

    
    @BeforeEach
    void setUp() {
    	calculator = new Calculator();
        System.out.println("Starting a new test...");
    }

    @AfterEach
    void tearDown() {
        calculator = null;
        System.out.println("Test finished.\n");
    }

    @Test
    public void testAddition() {
        assertEquals(5, calculator.add(2, 3), DELTA);
        assertEquals(-1, calculator.add(-2, 1), DELTA);
        assertNotEquals(10, calculator.add(2, 3), DELTA);
    }

    @Test
    public void testSubtraction() {
        assertEquals(1, calculator.subtract(3, 2), DELTA);
        assertEquals(-3, calculator.subtract(-2, 1), DELTA);
        assertTrue(calculator.subtract(5, 2) > 0);
    }

    @Test
    public void testMultiplication() {
        assertEquals(6, calculator.multiply(2, 3), DELTA);
        assertEquals(0, calculator.multiply(0, 5), DELTA);
        assertNotEquals(10, calculator.multiply(2, 3), DELTA);
    }

    @Test
    public void testDivision() {
        assertEquals(2, calculator.divide(6, 3), DELTA);
        assertEquals(-2, calculator.divide(-6, 3), DELTA);
        assertTrue(calculator.divide(0, 5) == 0);
    }

    @Test
    public void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}