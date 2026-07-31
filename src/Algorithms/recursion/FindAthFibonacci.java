package Algorithms.recursion;

/**
 * ============================================================
 * Problem            : Find A-th Fibonacci
 * Platform           : InterviewBit
 * Link               : https://www.interviewbit.com/problems/find-fibonacci/
 * Similar LeetCode   : https://leetcode.com/problems/fibonacci-number/
 * Difficulty         : Easy
 *
 * Approach           : Recursion
 * Algorithm          : Recursive Fibonacci
 *
 * Time Complexity    : O(2^n)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class FindAthFibonacci {

    /**
     * Returns the A-th Fibonacci number.
     *
     * @param n Position of the Fibonacci number
     * @return A-th Fibonacci number
     */
    public static int findAthFibonacci(int n) {

        // Base case
        if (n <= 1) {
            return n;
        }

        // Recursive case
        return findAthFibonacci(n - 1) + findAthFibonacci(n - 2);
    }

    public static void main(String[] args) {

        // Sample input
        int n = 6;

        // Calling the solution
        int result = findAthFibonacci(n);

        // Printing output
        System.out.println("Fibonacci Number: " + result);
    }
}