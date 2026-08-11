package Algorithms.DynamicProgramming;

/**
 * ============================================================
 * Problem            : Climbing Stairs
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/climbing-stairs/
 * Difficulty         : Easy
 *
 * Approach           : Dynamic Programming
 * Algorithm          : Bottom-Up DP (Tabulation)
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class ClimbingStairs {

    static int mod = 1_000_000_007;

    /**
     * Finds the number of distinct ways to reach the top.
     *
     * At every step, we can climb either 1 or 2 stairs.
     */
    public static int climbStairs(int n) {

        int[] dp = new int[n + 1];

        // Base cases
        if (n == 0 || n == 1) {
            return 1;
        }

        dp[0] = 1;
        dp[1] = 1;

        // Bottom-up DP / Tabulation
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }

        return dp[n];
    }

    public static void main(String[] args) {

        // Sample input
        int n = 5;

        // Calling the solution
        int result = climbStairs(n);

        // Printing output
        System.out.println("Number of Ways: " + result);
    }
}