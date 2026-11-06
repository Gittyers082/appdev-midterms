package appdev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * EXERCISE 1 - fill in each TODO. Delete the fail(...) line once you write the real test.
 * Read the SPEC at the top of src/appdev/BankAccount.java first.
 * One of these tests SHOULD fail when you finish - that's the bug. Then fix BankAccount.java.
 */
class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("Steven", 1000.0);
    }

    @Test
    void testInitialBalance() {
        // TODO: assertEquals the balance is 1000.0 (doubles need a delta!)
        fail("Not written yet");
    }

    @Test
    void testNegativeInitialBalanceThrows() {
        // TODO: assertThrows IllegalArgumentException when creating new BankAccount("X", -1)
        fail("Not written yet");
    }

    @Test
    void testDeposit() {
        // TODO: deposit 500, then assert the balance is 1500
        fail("Not written yet");
    }

    @Test
    void testDepositNegativeThrows() {
        // TODO: assertThrows IllegalArgumentException for deposit(-50)
        fail("Not written yet");
    }

    @Test
    void testDepositZeroThrows() {
        // TODO: the spec says amount <= 0 is invalid. What should deposit(0) do?
        fail("Not written yet");
    }

    @Test
    void testWithdraw() {
        // TODO: withdraw 300, assert balance is 700
        fail("Not written yet");
    }

    @Test
    void testWithdrawMoreThanBalanceThrows() {
        // TODO: assertThrows IllegalStateException for withdraw(5000)
        fail("Not written yet");
    }

    @Test
    void testWithdrawZeroThrows() {
        // TODO
        fail("Not written yet");
    }

    @Test
    void testWithdrawEntireBalance() {
        // TODO: boundary case - withdrawing exactly 1000 should be allowed and leave 0
        fail("Not written yet");
    }

    @Test
    void testTransfer() {
        // TODO: make a second account with 0, transfer 250 to it.
        // Use assertAll to check BOTH balances (750 and 250) in one test.
        fail("Not written yet");
    }

    // TODO (bonus): write a test that checks getOwner() returns "Steven".
    // TODO (bonus): turn the deposit test into a @ParameterizedTest with @ValueSource(doubles = {...})
}
