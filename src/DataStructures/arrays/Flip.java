package algorithms.kadane;

/**
 * ============================================================
 * Problem            : Flip
 * Platform           : InterviewBit
 * Link               : https://www.interviewbit.com/problems/flip/
 * Similar LeetCode   : https://leetcode.com/problems/maximum-subarray/
 * Difficulty         : Medium
 *
 * Approach           : Kadane's Algorithm
 * Algorithm          : Maximum Subarray Sum
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(1)
 * ============================================================
 */

public class Flip {

    /**
     * Finds the lexicographically smallest interval to flip
     * such that the number of '1's is maximized.
     *
     * @param A Binary string
     * @return 1-based starting and ending indices of the flip interval
     */
    public static int[] flip(String A) {

        // Current gain
        int currentSum = 0;

        // Maximum gain found so far
        int maxSum = 0;

        // Starting index of current subarray
        int start = 0;

        // Final answer indices
        int left = -1;
        int right = -1;

        for (int i = 0; i < A.length(); i++) {

            // '0' contributes +1, '1' contributes -1
            currentSum += (A.charAt(i) == '0') ? 1 : -1;

            // Reset if current gain becomes negative
            if (currentSum < 0) {
                currentSum = 0;
                start = i + 1;
            }

            // Update best interval
            if (currentSum > maxSum) {
                maxSum = currentSum;
                left = start;
                right = i;
            }
        }

        // No beneficial flip exists
        if (left == -1) {
            return new int[0];
        }

        // Return 1-based indices
        return new int[]{left + 1, right + 1};
    }

    public static void main(String[] args) {

        // Sample input
        String A = "010";

        // Calling the solution
        int[] result = flip(A);

        // Printing output
        if (result.length == 0) {
            System.out.println("No flip required");
        } else {
            System.out.println("Start Index : " + result[0]);
            System.out.println("End Index   : " + result[1]);
        }
    }
}