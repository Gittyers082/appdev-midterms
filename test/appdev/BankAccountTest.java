package appdev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
        assertEquals(1000.0, account.getBalance(), 0.0001);
    }

    @Test
    void testNegativeInitialBalanceThrows() {
        // TODO: assertThrows IllegalArgumentException when creating new BankAccount("X", -1)
        assertThrows(IllegalArgumentException.class, () -> new BankAccount("X", -1));
    }

    @Test
    void testDeposit() {
        // TODO: deposit 500, then assert the balance is 1500
        account.deposit(500);
        assertEquals(1500.0, account.getBalance(), 0.0001);
    }

    @Test
    void testDepositNegativeThrows() {
        // TODO: assertThrows IllegalArgumentException for deposit(-50)
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50));
    }

    @Test
    void testDepositZeroThrows() {
        // TODO: the spec says amount <= 0 is invalid. What should deposit(0) do?
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
    }

    @Test
    void testWithdraw() {
        // TODO: withdraw 300, assert balance is 700
        account.withdraw(300);
        assertEquals(700.0, account.getBalance(), 0.0001);
    }

    @Test
    void testWithdrawMoreThanBalanceThrows() {
        // TODO: assertThrows IllegalStateException for withdraw(5000)
        assertThrows(IllegalStateException.class, () -> account.withdraw(5000));
    }

    @Test
    void testWithdrawZeroThrows() {
        // TODO
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
    }

    @Test
    void testWithdrawEntireBalance() {
        // TODO: boundary case - withdrawing exactly 1000 should be allowed and leave 0
        account.withdraw(1000);
        assertEquals(0.0, account.getBalance(), 0.0001);
    }

    @Test
    void testTransfer() {
        // TODO: make a second account with 0, transfer 250 to it.
        // Use assertAll to check BOTH balances (750 and 250) in one test.
        BankAccount other = new BankAccount("Joestar", 0.0);
        account.transferTo(other, 250);
        assertAll(
                () -> assertEquals(750.0, account.getBalance(), 0.0001),
                () -> assertEquals(250.0, other.getBalance(), 0.0001)
        );
    }

    // TODO (bonus): write a test that checks getOwner() returns "Steven".
    @Test 
    void TestGetOwner() {
        assertEquals("Steven", account.getOwner());
    }

    // TODO (bonus): turn the deposit test into a @ParameterizedTest with @ValueSource(doubles = {...})
    @ParameterizedTest 
    @ValueSource (doubles = {100.0, 250.5, 0.01})
    void ParameterizedDepositTest(double amount) {
        account.deposit(amount);
        assertEquals(1000.0 + amount, account.getBalance(), 0.0001);
    }
}
