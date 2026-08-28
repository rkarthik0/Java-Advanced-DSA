/**
 * ============================================================
 * Problem            : Reverse a String
 * Category           : Algorithms.String
 * Created By         : Karthik R
 *
 * Approach           : StringBuilder
 * Algorithm          : Reverse
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(N)
 *
 * Idea:
 * - Convert the string into StringBuilder.
 * - Use reverse() to reverse all characters.
 * - Convert it back to String.
 * ============================================================
 */

public class ReverseString {

    public String solve(String A) {

        StringBuilder ans = new StringBuilder(A);

        // Reverse the string.
        ans.reverse();

        return ans.toString();
    }

    public static void main(String[] args) {

        ReverseString obj = new ReverseString();

        String A = "hello";

        System.out.println(obj.solve(A));
    }
}