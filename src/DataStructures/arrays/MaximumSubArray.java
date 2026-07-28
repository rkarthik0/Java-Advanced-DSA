package datastructures.arrays;

/**
 * ============================================================
 * Problem            : Maximum Subarray
 * Platform           : LeetCode / InterviewBit
 * Link               : https://leetcode.com/problems/maximum-subarray/
 * Difficulty         : Medium
 *
 * Approach           : Kadane's Algorithm
 * Algorithm          : Dynamic Programming (Optimized)
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(1)
 * ============================================================
 */

public class MaximumSubArray {

    /**
     * Finds the contiguous subarray with the largest sum.
     *
     * Kadane's Algorithm idea:
     * - Keep adding elements to the current subarray sum.
     * - Update maximum sum whenever current sum is greater.
     * - If current sum becomes negative, reset it because it
     *   cannot contribute to a future maximum sum.
     *
     * @param A Input integer array
     * @return Maximum possible sum of a contiguous subarray
     */
    public static int maxSubArray(int[] A) {

        // Stores the maximum subarray sum found so far
        int max = Integer.MIN_VALUE;

        // Stores the current subarray sum
        int currentSum = 0;

        // Traverse through all elements
        for (int i = 0; i < A.length; i++) {

            // Add current element to the running sum
            currentSum += A[i];

            // Update maximum sum if current sum is greater
            max = Math.max(max, currentSum);

            // If current sum becomes negative,
            // start a new subarray from the next element
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        // Sample input
        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        // Calling the solution
        int result = maxSubArray(A);

        // Printing output
        System.out.println("Maximum Subarray Sum: " + result);
    }
}