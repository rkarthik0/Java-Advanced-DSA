package Algorithms.Strings;

/**
 * ============================================================
 * Problem            : String Transformation
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Easy
 *
 * Approach           : String Traversal
 * Algorithm          : String Manipulation
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class StringTransformation {

    /**
     * Duplicates the string, removes uppercase characters,
     * and replaces lowercase vowels with '#'.
     *
     * @param str Input string
     * @return Transformed string
     */
    public static String solve(String str) {

        // Concatenate the string with itself
        str = str + str;

        // Remove all uppercase characters
        str = str.replaceAll("[A-Z]", "");

        StringBuilder result = new StringBuilder(str);

        // Replace lowercase vowels with '#'
        for (int i = 0; i < result.length(); i++) {

            char current = result.charAt(i);

            if (current == 'a' ||
                    current == 'e' ||
                    current == 'i' ||
                    current == 'o' ||
                    current == 'u') {

                result.setCharAt(i, '#');
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        // Sample input
        String str = "AbcaE";

        // Calling the solution
        String result = solve(str);

        // Printing output
        System.out.println("Transformed String: " + result);
    }
}