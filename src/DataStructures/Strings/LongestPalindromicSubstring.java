package DataStructures.Strings;

/**
 * ============================================================
 * Problem            : Longest Palindromic Substring
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/longest-palindromic-substring/
 * Difficulty         : Medium
 *
 * Approach           : Expand Around Center
 * Algorithm          : Two Pointers
 *
 * Time Complexity    : O(n²)
 * Space Complexity   : O(1)
 * ============================================================
 */

public class LongestPalindromicSubstring {

    /**
     * Finds the longest palindromic substring.
     *
     * Every character is considered as the center of an odd-length
     * palindrome, and every gap between two characters is considered
     * as the center of an even-length palindrome.
     *
     * @param str Input string
     * @return Longest palindromic substring
     */
    public static String longestPalindrome(String str) {

        int n = str.length();

        // Empty string case
        if (n == 0) {
            return "";
        }

        int start = 0;
        int maxLength = 1;

        // Try every possible center
        for (int i = 0; i < n; i++) {

            // Odd-length palindrome
            int left = i;
            int right = i;

            while (left >= 0 &&
                    right < n &&
                    str.charAt(left) == str.charAt(right)) {

                if (maxLength < right - left + 1) {
                    maxLength = right - left + 1;
                    start = left;
                }

                left--;
                right++;
            }

            // Even-length palindrome
            left = i;
            right = i + 1;

            while (left >= 0 &&
                    right < n &&
                    str.charAt(left) == str.charAt(right)) {

                if (maxLength < right - left + 1) {
                    maxLength = right - left + 1;
                    start = left;
                }

                left--;
                right++;
            }
        }

        return str.substring(start, start + maxLength);
    }

    public static void main(String[] args) {

        // Sample input
        String str = "babad";

        // Calling the solution
        String result = longestPalindrome(str);

        // Printing output
        System.out.println("Longest Palindromic Substring: " + result);
    }
}