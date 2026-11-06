# Refactoring Exercise

Files: `src/appdev/refactor/` (the smelly code) and `test/appdev/refactor/OrderProcessorTest.java` (the safety net).

> **Refactoring** = changing the internal structure **without changing observable behavior**.
> **Precondition: solid tests.** That's what `OrderProcessorTest` is for: it passes now, and it must keep passing after every step.

## Part A - Smell hunt (don't change any code yet)

Read all four files in `src/appdev/refactor/`. Find **at least 8 code smells** from Module 6 and fill in this table.
Smell names to choose from: duplicate code, long method, large class, long parameter list, divergent change, shotgun surgery,
feature envy, data clumps, primitive obsession, switch statements, lazy class, speculative generality, temporary field, comments.

| # | Smell | Where (file + method/line) | Refactoring that fixes it |
|---|-------|---------------------------|---------------------------|
| 1 |       |                           |                           |
| 2 |       |                           |                           |
| 3 |       |                           |                           |
| 4 |       |                           |                           |
| 5 |       |                           |                           |
| 6 |       |                           |                           |
| 7 |       |                           |                           |
| 8 |       |                           |                           |

Send the table to Claude to check before starting Part B.

## Part B - Refactor, one step at a time

After **every** step: run `ant`, check that everything is green, then commit (e.g. `git commit -m "Refactor: extract calculateDiscount"`).
If a test goes red, undo your last change. Don't "fix" the test.

1. **Extract Method:** pull the duplicated discount `switch` into one `private double calculateDiscount(String customerType, double subtotal)` and call it from both places.
2. **Extract Method:** do the same for tax (`calculateTax`), shipping (`calculateShipping`) and the receipt (`buildReceipt`). `processOrder` should end up short and readable, and most of the comments become unnecessary.
3. **Remove the temporary field:** turn `tempSubtotal` into a local variable.
4. **Move Method:** `customerLabel` mostly uses `Customer`'s data, so move it into `Customer` as `getLabel()`. Update the test call site.
5. **Introduce Parameter Object:** `processOrder` takes `customerName, customerEmail, customerPhone` separately, even though a `Customer` class already exists. Change it to take a `Customer`. Update the test call sites, but not the expected values.
6. **Replace Conditional with Polymorphism:** replace the `"GOLD"`/`"SILVER"`/`"REGULAR"` strings with an `enum CustomerType` where each constant knows its own discount rate (and whether it gets free shipping). This removes the switch statements.
7. **Remove dead weight:** delete `LegacyLogger` and `ReportExporter` (right-click → Delete in VS Code). Check nothing breaks.

Bonus: the numbers `0.12`, `0.15`, `50`, `150`, `250` are "magic numbers". Replace them with named constants such as `private static final double VAT_RATE = 0.12;`.
