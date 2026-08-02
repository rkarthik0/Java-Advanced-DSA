package Algorithms.Strings;

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
     * @param str Input string
     * @return Longest palindromic substring
     */
    public static String longestPalindrome(String str) {

        int n = str.length();

        // Stores the starting index of the longest palindrome
        int start = 0;

        // Stores the maximum palindrome length
        int maxLength = 1;

        // Consider every character as the center
        for (int i = 0; i < n; i++) {

            // Check for odd-length palindrome
            int left = i;
            int right = i;

            while (left >= 0 && right < n &&
                    str.charAt(left) == str.charAt(right)) {

                if (right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    start = left;
                }

                left--;
                right++;
            }

            // Check for even-length palindrome
            left = i;
            right = i + 1;

            while (left >= 0 && right < n &&
                    str.charAt(left) == str.charAt(right)) {

                if (right - left + 1 > maxLength) {
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