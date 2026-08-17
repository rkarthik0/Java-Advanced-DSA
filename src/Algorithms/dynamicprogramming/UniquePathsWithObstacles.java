import java.util.*;

/**
 * ============================================================
 * Problem : Unique Paths With Obstacles
 *
 * Approach:
 * Dynamic Programming + Space Optimization
 *
 * Time Complexity  : O(N * M)
 * Space Complexity : O(M)
 *
 * Idea:
 *
 * Normally:
 *
 *     dp[j] = paths from top + paths from left
 *
 * Since we only need the previous row and the current row,
 * we can store everything in a single 1D array.
 *
 * dp[j] represents the number of ways to reach column j
 * in the current row.
 *
 * For an obstacle:
 *
 *     dp[j] = 0
 *
 * because no path can pass through that cell.
 *
 * For a normal cell:
 *
 *     dp[j] = dp[j] + dp[j - 1]
 *              ↑          ↑
 *             top        left
 *
 * ============================================================
 */

public class UniquePathsWithObstacles {

    public static int uniquePathsWithObstacles(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        // dp[j] = number of ways to reach column j
        // in the current row.
        int[] dp = new int[m];

        // Starting cell:
        // If it is an obstacle, there are 0 ways.
        // Otherwise, there is exactly 1 way to start.
        dp[0] = (A[0][0] == 1) ? 0 : 1;

        // Traverse the matrix row by row.
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                // Obstacle -> no path can pass through it.
                if (A[i][j] == 1) {
                    dp[j] = 0;
                }

                // Normal cell:
                // dp[j]     = paths from top
                // dp[j - 1] = paths from left
                else if (j > 0) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }

        return dp[m - 1];
    }

    public static void main(String[] args) {

        int[][] A = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        System.out.println(
                uniquePathsWithObstacles(A)
        );
    }
}