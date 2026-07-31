package Algorithms.sorting;

/**
 * ============================================================
 * Problem            : Merge Two Sorted Arrays
 * Platform           : InterviewBit
 * Link               : https://www.interviewbit.com/problems/merge-two-sorted-lists-ii/
 * Similar LeetCode   : https://leetcode.com/problems/merge-sorted-array/
 * Difficulty         : Easy
 *
 * Approach           : Two Pointers
 * Algorithm          : Merge Process
 *
 * Time Complexity    : O(n + m)
 * Space Complexity   : O(n + m)
 * ============================================================
 */

public class MergeTwoSortedArrays {

    /**
     * Merges two sorted arrays into a single sorted array.
     *
     * @param A First sorted array
     * @param B Second sorted array
     * @return Merged sorted array
     */
    public static int[] solve(int[] A, int[] B) {

        int n = A.length;
        int m = B.length;

        int i = 0, j = 0, k = 0;

        // Result array
        int[] result = new int[n + m];

        // Merge both arrays
        while (i < n && j < m) {

            if (A[i] <= B[j]) {
                result[k++] = A[i++];
            } else {
                result[k++] = B[j++];
            }
        }

        // Copy remaining elements of A
        while (i < n) {
            result[k++] = A[i++];
        }

        // Copy remaining elements of B
        while (j < m) {
            result[k++] = B[j++];
        }

        return result;
    }

    public static void main(String[] args) {

        // Sample input
        int[] A = {1, 3, 5, 7};
        int[] B = {2, 4, 6, 8};

        // Calling the solution
        int[] result = solve(A, B);

        // Printing output
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}