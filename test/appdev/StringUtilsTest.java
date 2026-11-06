package appdev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * EXERCISE 2 - this one is less guided. Only the method names are given.
 * StringUtils methods are static, so call them as StringUtils.reverse("abc") - no setUp needed.
 *
 * Test scenarios from Module 6 to cover for each method:
 *   valid input, null input, empty string "", and mismatched / edge-case data.
 */
class StringUtilsTest {

    @Test
    void testReverse() {
        // TODO: "abc" -> "cba", "" -> "", null -> null (assertNull)
        fail("Not written yet");
    }

    @Test
    void testIsPalindrome() {
        // TODO: "racecar" true, "Level" true (case-insensitive), "java" false, null false
        fail("Not written yet");
    }

    @Test
    void testCountVowels() {
        // TODO
        fail("Not written yet");
    }

    // TODO: write testValidEmails as a @ParameterizedTest with @ValueSource(strings = {...})
    //       e.g. "steven@gmail.com", "a.b@slu.edu"

    // TODO: write testInvalidEmails the same way
    //       e.g. "no-at-sign.com", "@gmail.com", "steven@gmail"

    // TODO: write tests for isValidPhMobile
    //       valid: "09171234567"   invalid: "0917123456" (10 digits), "08171234567", "0917-123-4567"
}
