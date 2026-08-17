import java.util.*;

/**
 * ============================================================
 * Problem : Adjacent
 *
 * Approach:
 * Dynamic Programming + Space Optimization
 *
 * Time Complexity  : O(N)
 * Space Complexity : O(1)
 *
 * Idea:
 *
 * We cannot select two adjacent elements.
 *
 * Since the matrix has only 2 rows, for every column we can
 * choose at most ONE element.
 *
 * For each column:
 *
 *     currValue = max(A[0][i], A[1][i])
 *
 * Now the problem becomes:
 *
 *     Choose maximum sum from an array where
 *     adjacent elements cannot both be selected.
 *
 * This is exactly the House Robber DP pattern.
 * ============================================================
 */

public class AdjacentMaximumSum {

    public static int adjacent(int[][] A) {

        int n = A[0].length;

        /*
         * prev2 = maximum sum up to column i - 2
         * prev1 = maximum sum up to column i - 1
         */
        int prev2 = 0;
        int prev1 = 0;

        for (int i = 0; i < n; i++) {

            /*
             * From the current column, we can choose
             * at most one element.
             *
             * So choose the larger of the two.
             */
            int currValue = Math.max(
                    A[0][i],
                    A[1][i]
            );

            /*
             * Two choices:
             *
             * 1. Don't choose current column
             *    -> prev1
             *
             * 2. Choose current column
             *    -> prev2 + currValue
             *
             * We cannot use prev1 because that represents
             * the previous column, which is adjacent.
             */
            int curr = Math.max(
                    prev1,
                    prev2 + currValue
            );

            // Move DP variables forward.
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {

        int[][] A = {
                {1, 2, 3, 4},
                {2, 3, 4, 5}
        };

        System.out.println(
                "Maximum Sum: " + adjacent(A)
        );
    }
}