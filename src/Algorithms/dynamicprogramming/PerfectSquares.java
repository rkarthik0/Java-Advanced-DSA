package Algorithms.DynamicProgramming;

/**
 * ============================================================
 * Problem            : Perfect Squares
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/perfect-squares/
 * Difficulty         : Medium
 *
 * Approach           : Dynamic Programming
 * Algorithm          : Bottom-Up DP (Tabulation)
 *
 * Time Complexity    : O(n * sqrt(n))
 * Space Complexity   : O(n)
 * ============================================================
 */

public class PerfectSquares {

    /**
     * Finds the minimum number of perfect square numbers
     * whose sum is equal to n.
     *
     * Example:
     * n = 12
     *
     * 12 = 4 + 4 + 4
     *
     * Answer = 3
     */
    public static int countMinSquares(int n) {

        int[] dp = new int[n + 1];

        // dp[i] stores the minimum number of
        // perfect squares required to form i.
        dp[0] = 0;

        // Bottom-up DP / Tabulation
        for (int i = 1; i <= n; i++) {

            int min = Integer.MAX_VALUE;

            // Try every perfect square <= i
            for (int j = 1; j * j <= i; j++) {

                int square = j * j;

                // Use the current perfect square and
                // solve the remaining value.
                min = Math.min(min, dp[i - square] + 1);
            }

            dp[i] = min;
        }

        return dp[n];
    }

    public static void main(String[] args) {

        // Sample input
        int n = 12;

        // Calling the solution
        int result = countMinSquares(n);

        // Printing output
        System.out.println("Minimum Number of Perfect Squares: " + result);
    }
}