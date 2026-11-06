package appdev;

/**
 * WORKED EXAMPLE - this class is already fully tested in test/appdev/CalculatorTest.java.
 * Read both files side by side.
 */
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    /** Integer division. Throws ArithmeticException when b is 0. */
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    /** Average of the numbers. Throws IllegalArgumentException for null or empty arrays. */
    public double average(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return (double) sum / numbers.length;
    }

    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    /** Returns a new array where every element is squared. */
    public int[] squares(int[] numbers) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = numbers[i] * numbers[i];
        }
        return result;
    }
}
