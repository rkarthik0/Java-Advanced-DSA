/**
 * ============================================================
 * Problem            : Pascal's Triangle
 * Created By         : Karthik R
 *
 * Approach           : Dynamic Programming
 * Algorithm          : Pascal's Triangle Construction
 *
 * Time Complexity    : O(A^2)
 * Space Complexity   : O(A^2)
 *
 * Idea:
 * - First and last elements of every row are 1.
 * - Every inner element is obtained from:
 *   dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
 * ============================================================
 */

public class PascalsTriangle {

    public int[][] solve(int A) {

        int[][] dp = new int[A][A];

        for (int i = 0; i < A; i++) {

            for (int j = 0; j <= i; j++) {

                // First and last element of every row
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                }

                // Inner elements
                else {
                    dp[i][j] =
                            dp[i - 1][j - 1]
                                    + dp[i - 1][j];
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) {

        PascalsTriangle obj =
                new PascalsTriangle();

        int[][] result = obj.solve(5);

        for (int i = 0; i < result.length; i++) {

            for (int j = 0; j <= i; j++) {
                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }
    }
}