package appdev;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

// "import static" lets you write assertEquals(...) instead of Assertions.assertEquals(...)
import static org.junit.jupiter.api.Assertions.*;

/**
 * WORKED EXAMPLE - every annotation and assertion from the module is used here at least once.
 * Run it, then watch the console: the println calls show you the lifecycle ORDER.
 */
@DisplayName("Calculator tests")
class CalculatorTest {

    private Calculator calc;

    // ---------- LIFECYCLE ----------

    @BeforeAll                      // runs ONCE before all tests - must be static
    static void initAll() {
        System.out.println(">>> @BeforeAll (once)");
    }

    @BeforeEach                     // runs before EVERY test - this is the "setUp" method
    void setUp() {
        calc = new Calculator();    // fresh object per test, so tests don't affect each other
        System.out.println("  -> @BeforeEach");
    }

    @AfterEach                      // runs after EVERY test - this is the "tearDown" method
    void tearDown() {
        calc = null;
        System.out.println("  <- @AfterEach");
    }

    @AfterAll                       // runs ONCE after all tests - must be static
    static void tearDownAll() {
        System.out.println("<<< @AfterAll (once)");
    }

    // ---------- BASIC ASSERTIONS ----------

    @Test
    @DisplayName("2 + 3 = 5")
    void testAdd() {
        // assertEquals(EXPECTED, ACTUAL) - expected always comes first
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void testSubtractWithMessage() {
        // the optional failure message goes LAST
        assertEquals(1, calc.subtract(3, 2), "3 - 2 should be 1");
    }

    @Test
    void testIsEven() {
        assertTrue(calc.isEven(4));
        assertFalse(calc.isEven(7));
    }

    @Test
    void testAverageUsesDelta() {
        // doubles: give a delta (tolerance) because of floating-point rounding
        assertEquals(2.5, calc.average(new int[]{2, 3}), 0.0001);
    }

    @Test
    void testSquaresArray() {
        // arrays: assertEquals would compare references - use assertArrayEquals
        int[] expected = {1, 4, 9};
        assertArrayEquals(expected, calc.squares(new int[]{1, 2, 3}));
    }

    @Test
    void testSameVsEquals() {
        Calculator other = new Calculator();
        Calculator alias = calc;
        assertSame(calc, alias);        // same object in memory (==)
        assertNotSame(calc, other);     // two different objects
        assertNotNull(calc);
    }

    // ---------- EXCEPTIONS ----------

    @Test
    void testDivideByZeroThrows() {
        // assertThrows(ExceptionType.class, lambda-with-the-code-that-should-throw)
        ArithmeticException ex = assertThrows(
                ArithmeticException.class,
                () -> calc.divide(10, 0)
        );
        // assertThrows RETURNS the exception, so you can check the message too
        assertEquals("Cannot divide by zero", ex.getMessage());
    }

    @Test
    void testAverageOfEmptyArrayThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.average(new int[]{}));
    }

    // ---------- GROUPING & TIME ----------

    @Test
    void testMultiplyGrouped() {
        // assertAll runs EVERY assertion and reports ALL failures, not just the first one
        assertAll("multiply",
                () -> assertEquals(6, calc.multiply(2, 3)),
                () -> assertEquals(0, calc.multiply(5, 0)),
                () -> assertEquals(-8, calc.multiply(-2, 4))
        );
    }

    @Test
    void testAddIsFast() {
        // fails if the code takes longer than the given duration
        assertTimeout(Duration.ofMillis(100), () -> calc.add(1, 2));
    }

    // ---------- SPECIAL TEST TYPES ----------

    @ParameterizedTest                       // replaces @Test - runs once per value
    @ValueSource(ints = {2, 4, 100, -6})
    void testEvenNumbers(int n) {
        assertTrue(calc.isEven(n));
    }

    @ParameterizedTest
    @CsvSource({                             // each line = "a, b, expected"
            "1, 1, 2",
            "10, -5, 5",
            "0, 0, 0"
    })
    void testAddMany(int a, int b, int expected) {
        assertEquals(expected, calc.add(a, b));
    }

    @RepeatedTest(3)                         // replaces @Test - runs 3 times
    void testRepeated() {
        assertEquals(4, calc.add(2, 2));
    }

    @Test
    @Disabled("Example of a skipped test")   // shows as skipped, not failed
    void testNotReadyYet() {
        fail("This should never run");
    }
}
