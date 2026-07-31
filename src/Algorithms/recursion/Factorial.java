package Algorithms.recursion;

/**
 * ============================================================
 * Problem            : Factorial
 * Platform           : LeetCode (similar)
 * Link               : https://leetcode.com/problems/factorial-trailing-zeroes/
 * Difficulty         : Easy
 *
 * Approach           : Recursion
 * Algorithm          : Recursive Factorial
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class Factorial {

    /**
     * Computes the factorial of a non-negative integer.
     *
     * @param n Input number
     * @return Factorial of n
     */
    public static int solve(int n) {

        // Base case: 0! = 1
        if (n == 0) {
            return 1;
        }

        // Recursive case
        return n * solve(n - 1);
    }

    public static void main(String[] args) {

        // Sample input
        int n = 5;

        // Calling the solution
        int result = solve(n);

        // Printing output
        System.out.println("Factorial: " + result);
    }
}