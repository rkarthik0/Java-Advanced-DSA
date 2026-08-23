/**
 * ============================================================
 * Problem            : Count "bob" Substrings
 * Created By         : Karthik R
 *
 * Approach           : String Traversal
 * Algorithm          : Fixed-Size Sliding Window
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(1)
 *
 * Idea:
 * - Check every group of 3 consecutive characters.
 * - If the group is "bob", increment the count.
 * ============================================================
 */

public class CountBobSubstrings {

    public int solve(String A) {

        int count = 0;

        for (int i = 0; i < A.length() - 2; i++) {

            if (A.charAt(i) == 'b'
                    && A.charAt(i + 1) == 'o'
                    && A.charAt(i + 2) == 'b') {

                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        CountBobSubstrings obj =
                new CountBobSubstrings();

        String A = "bobob";

        System.out.println(obj.solve(A));
    }
}