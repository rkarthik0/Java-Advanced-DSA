/**
 * ============================================================
 * Problem            : Check Alphanumeric Characters
 * Created By         : Karthik R
 *
 * Approach           : Character Traversal
 * Algorithm          : Character Validation
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(1)
 *
 * Idea:
 * - Traverse every character.
 * - If any character is not a letter or digit, return 0.
 * - If all characters are valid, return 1.
 * ============================================================
 */

public class AlphanumericCheck {

    public int solve(char[] A) {

        for (char c : A) {

            if (!Character.isLetterOrDigit(c)) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {

        AlphanumericCheck obj =
                new AlphanumericCheck();

        char[] A = {'A', 'b', '1', '2', '3'};

        System.out.println(obj.solve(A));
    }
}
