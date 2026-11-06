package appdev;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
        assertEquals("cba", StringUtils.reverse("abc"));
        assertEquals("", StringUtils.reverse(""));
        assertNull(StringUtils.reverse(null));
    }

    @Test
    void testIsPalindrome() {
        // TODO: "racecar" true, "Level" true (case-insensitive), "java" false, null false
        assertTrue(StringUtils.isPalindrome("racecar"));
        assertTrue(StringUtils.isPalindrome("Level"));
        assertFalse(StringUtils.isPalindrome("java"));
        assertFalse(StringUtils.isPalindrome(null));
    }

    @Test
    void testCountVowels() {
        assertEquals(1, StringUtils.countVowels("gold"));
        assertEquals(5, StringUtils.countVowels("Education"));   
        assertEquals(0, StringUtils.countVowels("rhythm"));      
        assertEquals(0, StringUtils.countVowels(""));            
        assertEquals(0, StringUtils.countVowels(null));          
    }

    // TODO: write testValidEmails as a @ParameterizedTest with @ValueSource(strings = {...})
    //       e.g. "steven@gmail.com", "a.b@slu.edu"
    @ParameterizedTest 
    @ValueSource (strings = {"steven@gmail.com", "a.b@slu.edu"})
    void testValidEmails(String email) {
        assertTrue(StringUtils.isValidEmail(email));
    }

    // TODO: write testInvalidEmails the same way
    //       e.g. "no-at-sign.com", "@gmail.com", "steven@gmail"
    @ParameterizedTest 
    @ValueSource (strings = {"no-at-sign.com", "@gmail.com", "steven@gmail"})
    void testInvalidEmails(String email) {
        assertFalse(StringUtils.isValidEmail(email));
    }

    // TODO: write tests for isValidPhMobile
    //       valid: "09171234567"   invalid: "0917123456" (10 digits), "08171234567", "0917-123-4567"
    @Test 
    void TestIsValidPhMobile() {
        assertTrue(StringUtils.isValidPhMobile("09171234567"));
        assertFalse(StringUtils.isValidPhMobile("0917123456"));
        assertFalse(StringUtils.isValidPhMobile("08171234567"));
        assertFalse(StringUtils.isValidPhMobile("0917-123-4567"));
    }

}
