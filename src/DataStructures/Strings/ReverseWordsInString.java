/**
 * ============================================================
 * Problem            : Reverse Words in a String
 * Category           : Algorithms.String
 * Created By         : Karthik R
 *
 * Approach           : String Manipulation
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(N)
 *
 * Idea:
 * - Remove leading/trailing spaces using trim().
 * - Split the string using one or more spaces.
 * - Reverse the word array.
 * - Join the words with a single space.
 * ============================================================
 */
import java.util.*;
public class ReverseWordsInString {

    public String solve(String A) {

        // Split by one or more whitespace characters.
        String[] words = A.trim().split("\\s+");

        // Reverse the words.
        Collections.reverse(Arrays.asList(words));

        // Join words using a single space.
        return String.join(" ", words);
    }

    public static void main(String[] args) {

        ReverseWordsInString obj =
                new ReverseWordsInString();

        String A = "  hello world java  ";

        System.out.println(obj.solve(A));
    }
}