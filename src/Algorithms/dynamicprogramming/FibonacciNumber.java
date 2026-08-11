import java.util.*;

/**
 * ============================================================
 * Problem            : Fibonacci Number
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/fibonacci-number/
 * Difficulty         : Easy
 *
 * Approach           : Dynamic Programming
 * Algorithm          : Top-Down DP (Memoization)
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class FibonacciNumber {

    /**
     * Calculates the nth Fibonacci number using
     * Top-Down Dynamic Programming (Memoization).
     *
     * F(0) = 0
     * F(1) = 1
     *
     * F(n) = F(n - 1) + F(n - 2)
     */
    public static int fib(int n, int[] dp) {

        // Base cases
        if (n == 0 || n == 1) {
            dp[n] = n;
            return n;
        }

        // Return already calculated result
        if (dp[n] != -1) {
            return dp[n];
        }

        // Calculate the previous two Fibonacci numbers
        int first = fib(n - 1, dp);
        int second = fib(n - 2, dp);

        // Store the result for future calls
        dp[n] = first + second;

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 10;

        // Initialize DP array
        // -1 means the value has not been calculated yet
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        // Calculate Fibonacci number
        int result = fib(n, dp);

        // Print result
        System.out.println("Fibonacci Number: " + result);
    }
}