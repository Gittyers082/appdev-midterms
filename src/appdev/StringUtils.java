package appdev;

/**
 * EXERCISE 2 - write the tests in test/appdev/StringUtilsTest.java.
 * Bonus: two of these methods use regex, so you review both topics at once.
 */
public class StringUtils {

    /** Returns the reversed string, or null if input is null. */
    public static String reverse(String s) {
        if (s == null) {
            return null;
        }
        return new StringBuilder(s).reverse().toString();
    }

    /** True if s reads the same forwards and backwards, ignoring case. Null -> false. */
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        String lower = s.toLowerCase();
        return lower.equals(reverse(lower));
    }

    /** Counts a, e, i, o, u (upper or lower case). Null -> 0. */
    public static int countVowels(String s) {
        if (s == null) {
            return 0;
        }
        return s.replaceAll("[^aeiouAEIOU]", "").length();
    }

    /** Simplified email check: word chars/dots, @, word chars, dot, word chars. Null -> false. */
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return email.matches("^[\\w.]+@\\w+\\.\\w+$");
    }

    /** PH mobile number: exactly 11 digits starting with 09, e.g. 09171234567. Null -> false. */
    public static boolean isValidPhMobile(String number) {
        if (number == null) {
            return false;
        }
        return number.matches("^09\\d{9}$");
    }
}
