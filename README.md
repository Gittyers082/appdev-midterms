# appdev-midterms

im so cooked... (but less every commit)

JUnit 6 practice for the ITCS 311 midterm. Plain Java project, no Maven/Gradle - runs in VS Code or the terminal.

## Structure

```
src/appdev/        classes being tested
  Calculator.java    worked example
  BankAccount.java   exercise 1 (has one planted bug)
  StringUtils.java   exercise 2 (includes regex)
test/appdev/       JUnit tests
  CalculatorTest.java   complete - study this
  BankAccountTest.java  guided TODOs
  StringUtilsTest.java  less guided TODOs
lib/               put junit-console.jar here
```

## Setup (once)

1. **Java 17 or newer** is required by JUnit 6. Check with `java -version`.
2. Download the JUnit jar into `lib/` as `junit-console.jar` (see `lib/PUT_JUNIT_JAR_HERE.txt`).
3. In VS Code, have the **Extension Pack for Java** installed, then reopen the folder.
   Test classes get a ▶ beside each method, and everything shows in the **Testing** tab (flask icon).

## Run from the terminal (PowerShell)

```powershell
javac -d bin -cp lib/junit-console.jar src/appdev/*.java test/appdev/*.java
java -jar lib/junit-console.jar execute -cp bin --scan-class-path
```

## Checklist

- [ ] Run `CalculatorTest`, read the console output, and explain the lifecycle order
- [ ] Break one test on purpose (change an expected value), see how the failure looks, then undo it
- [ ] Finish `BankAccountTest`
- [ ] Find the bug with a failing test, fix `BankAccount.java`, and get all tests green
- [ ] Finish `StringUtilsTest` (use `@ParameterizedTest` for the email/phone tests)
- [ ] Write a test class from scratch for a new class of your own
