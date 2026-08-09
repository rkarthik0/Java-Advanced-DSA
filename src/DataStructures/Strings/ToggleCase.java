package Algorithms.Strings;

/**
 * ============================================================
 * Problem            : Toggle Case of Characters
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Easy
 *
 * Approach           : Character Traversal
 * Algorithm          : ASCII Manipulation
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class ToggleCase {

    /**
     * Toggles the case of every alphabetic character.
     *
     * Uppercase characters are converted to lowercase
     * and lowercase characters are converted to uppercase.
     *
     * @param str Input string
     * @return String with toggled character cases
     */
    public static String solve(String str) {

        StringBuilder result = new StringBuilder();

        // Traverse each character of the string
        for (int i = 0; i < str.length(); i++) {

            char current = str.charAt(i);

            // Convert uppercase to lowercase
            if (current >= 'A' && current <= 'Z') {
                current = (char) (current + 32);
            }

            // Convert lowercase to uppercase
            else {
                current = (char) (current - 32);
            }

            result.append(current);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        // Sample input
        String str = "HeLLo";

        // Calling the solution
        String result = solve(str);

        // Printing output
        System.out.println("Toggled String: " + result);
    }
}