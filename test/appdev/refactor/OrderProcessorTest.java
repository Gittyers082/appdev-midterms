package appdev.refactor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SAFETY NET - these tests pin down the CURRENT behavior of OrderProcessor.
 * They all pass right now. They must STILL pass after every refactoring step.
 *
 * RULE: you may change HOW a method is called (if you change its signature),
 *       but you may NEVER change an expected value. Changing an expected value
 *       means you changed the behavior - and that's not refactoring anymore.
 */
class OrderProcessorTest {

    private OrderProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new OrderProcessor();
    }

    @Test
    void testFullReceiptGoldNcr() {
        String expected =
                "Customer: Steven <steven@slu.edu.ph> 09171234567\n"
                + "Item: Keyboard x2\n"
                + "Subtotal: 2000.00\n"
                + "Discount: 300.00\n"
                + "Tax: 204.00\n"
                + "Shipping: 0.00\n"
                + "Total: 1904.00";
        String actual = processor.processOrder("Steven", "steven@slu.edu.ph", "09171234567",
                "GOLD", "Keyboard", 1000.0, 2, "NCR");
        assertEquals(expected, actual);
    }

    @Test
    void testSilverLuzonTotal() {
        String receipt = processor.processOrder("Ana", "ana@mail.com", "09181112222",
                "SILVER", "Mouse", 500.0, 3, "LUZON");
        assertAll(
                () -> assertTrue(receipt.contains("Discount: 150.00")),
                () -> assertTrue(receipt.contains("Shipping: 150.00")),
                () -> assertTrue(receipt.endsWith("Total: 1662.00"))
        );
    }

    @Test
    void testRegularOtherRegionTotal() {
        String receipt = processor.processOrder("Ben", "ben@mail.com", "09190001111",
                "REGULAR", "Cable", 100.0, 1, "VISAYAS");
        assertAll(
                () -> assertTrue(receipt.contains("Discount: 0.00")),
                () -> assertTrue(receipt.contains("Shipping: 250.00")),
                () -> assertTrue(receipt.endsWith("Total: 362.00"))
        );
    }

    @Test
    void testEstimateTotal() {
        assertAll(
                () -> assertEquals(1904.0, processor.estimateTotal("GOLD", 1000.0, 2), 0.0001),
                () -> assertEquals(1512.0, processor.estimateTotal("SILVER", 500.0, 3), 0.0001),
                () -> assertEquals(112.0, processor.estimateTotal("REGULAR", 100.0, 1), 0.0001)
        );
    }

    @Test
    void testInvalidInputsThrow() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () ->
                        processor.processOrder("", "x@y.com", "0917", "GOLD", "X", 10.0, 1, "NCR")),
                () -> assertThrows(IllegalArgumentException.class, () ->
                        processor.processOrder("A", "x@y.com", "0917", "GOLD", "X", 0.0, 1, "NCR")),
                () -> assertThrows(IllegalArgumentException.class, () ->
                        processor.processOrder("A", "x@y.com", "0917", "GOLD", "X", 10.0, 0, "NCR"))
        );
    }

    @Test
    void testCustomerLabel() {
        Customer c = new Customer("Steven", "steven@slu.edu.ph", "09171234567");
        assertEquals("STEVEN (steven@slu.edu.ph, 09171234567)", processor.customerLabel(c));
    }
}
