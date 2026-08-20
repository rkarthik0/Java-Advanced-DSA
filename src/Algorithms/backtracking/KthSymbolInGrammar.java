/**
 * ============================================================
 * Problem            : K-th Symbol in Grammar
 * Created By         : Karthik R
 *
 * Approach           : Recursion
 * Algorithm          : Divide and Conquer
 *
 * Time Complexity    : O(A)
 * Space Complexity   : O(A)  // Recursion stack
 *
 * Idea:
 * - The first symbol of every row is always 0.
 * - Every row is generated from the previous row:
 *
 *       0 -> 01
 *       1 -> 10
 *
 * - For position B:
 *      If B is even, it belongs to the second half
 *      If B is odd, it belongs to the first half.
 *
 * - We reduce the problem to the previous row using B / 2.
 * ============================================================
 */

public class KthSymbolInGrammar {

    public static int solve(int A, int B) {

        // Base case:
        // Row 1 contains only 0.
        if (A == 1) {
            return 0;
        }

        // Find the parent symbol in the previous row.
        int parent = solve(A - 1, (B + 1) / 2);

        // Odd position:
        // Same as parent.
        if (B % 2 == 1) {
            return parent;
        }

        // Even position:
        // Opposite of parent.
        return 1 - parent;
    }

    // ============================================================
    // MAIN METHOD
    // ============================================================

    public static void main(String[] args) {

        int A = 4;
        int B = 5;

        int result = solve(A, B);

        System.out.println(result);
    }
}