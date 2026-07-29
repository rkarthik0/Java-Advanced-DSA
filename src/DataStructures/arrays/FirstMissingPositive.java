package datastructures.arrays;

/**
 * ============================================================
 * Problem            : First Missing Positive
 * Platform           : LeetCode
 * Link               : https://leetcode.com/problems/first-missing-positive/
 * Difficulty         : Hard
 *
 * Approach           : Index Marking
 * Algorithm          : In-place Hashing
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(1)
 * ============================================================
 */

public class FirstMissingPositive {

    /**
     * Finds the smallest missing positive integer.
     *
     * @param A Input integer array
     * @return First missing positive integer
     */
    public static int firstMissingPositive(int[] A) {

        int n = A.length;

        // Replace all non-positive numbers with n + 1
        for (int i = 0; i < n; i++) {

            if (A[i] <= 0) {
                A[i] = n + 1;
            }
        }

        // Mark the presence of elements in the range [1, n]
        for (int i = 0; i < n; i++) {

            int element = Math.abs(A[i]);

            if (element >= 1 && element <= n) {

                int index = element - 1;

                // Mark the index as visited
                A[index] = -Math.abs(A[index]);
            }
        }

        // The first positive index indicates the missing positive number
        for (int i = 0; i < n; i++) {

            if (A[i] > 0) {
                return i + 1;
            }
        }

        // If all numbers from 1 to n are present
        return n + 1;
    }

    public static void main(String[] args) {

        // Sample input
        int[] A = {3, 4, -1, 1};

        // Calling the solution
        int result = firstMissingPositive(A);

        // Printing output
        System.out.println("First Missing Positive: " + result);
    }
}