package appdev;

/**
 * EXERCISE 1 - write the tests in test/appdev/BankAccountTest.java.
 *
 * SPEC (what the class is SUPPOSED to do):
 *  - new BankAccount(owner, initialBalance): throws IllegalArgumentException if initialBalance < 0
 *  - deposit(amount):  throws IllegalArgumentException if amount <= 0
 *  - withdraw(amount): throws IllegalArgumentException if amount <= 0
 *                      throws IllegalStateException    if amount > balance
 *  - transferTo(other, amount): withdraws from this account and deposits into the other
 *
 * WARNING: one method does NOT follow the spec. Don't hunt for it by reading -
 * write tests for every rule above (especially the boundary value 0) and let a test find it.
 */
public class BankAccount {

    private final String owner;
    private double balance;

    public BankAccount(String owner, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.owner = owner;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
    }

    public void transferTo(BankAccount other, double amount) {
        this.withdraw(amount);
        other.deposit(amount);
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }
}
