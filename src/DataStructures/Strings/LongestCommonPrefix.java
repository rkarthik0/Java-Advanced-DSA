package Algorithms.Strings;

/**
 * ============================================================
 * Problem            : Longest Common Prefix
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/longest-common-prefix/
 * Difficulty         : Easy
 *
 * Approach           : Vertical Scanning
 * Algorithm           : String Traversal
 *
 * Time Complexity    : O(n * m)
 * Space Complexity   : O(1)
 * ============================================================
 */

public class LongestCommonPrefix {

    /**
     * Finds the longest common prefix shared by all strings.
     *
     * @param strs Array of strings
     * @return Longest common prefix
     */
    public static String longestCommonPrefix(String[] strs) {

        // Handle empty input
        if (strs.length == 0) {
            return "";
        }

        // Check each character of the first string
        for (int i = 0; i < strs[0].length(); i++) {

            char current = strs[0].charAt(i);

            // Compare current character with all other strings
            for (int j = 1; j < strs.length; j++) {

                // Prefix ended if current string is shorter
                // or the characters do not match
                if (i >= strs[j].length() ||
                        strs[j].charAt(i) != current) {

                    return strs[0].substring(0, i);
                }
            }
        }

        // Entire first string is the common prefix
        return strs[0];
    }

    public static void main(String[] args) {

        // Sample input
        String[] strs = {"flower", "flow", "flight"};

        // Calling the solution
        String result = longestCommonPrefix(strs);

        // Printing output
        System.out.println("Longest Common Prefix: " + result);
    }
}