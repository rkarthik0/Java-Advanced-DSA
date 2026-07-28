package datastructures.arrays;

/**
 * ============================================================
 * Problem     : Two Sum
 * Platform    : LeetCode
 * Link        : https://leetcode.com/problems/two-sum/
 *
 * Approach    : Brute Force
 * Algorithm   : Nested Loops
 *
 * Time Complexity  : O(n^2)
 * Space Complexity : O(1)
 * ============================================================
 */

public class TwoSum {

    /**
     * Finds the indices of two numbers whose sum equals the target.
     *
     * @param nums   Input array
     * @param target Target sum
     * @return Indices of the two numbers
     */
    public static int[] TwoSum(int[] nums, int target) {

        // Check every possible pair in the array
        for (int i = 0; i < nums.length; i++) {

            // Start from the next element
            for (int j = i + 1; j < nums.length; j++) {

                // If the current pair matches the target
                if (nums[i] + nums[j] == target) {

                    // Return their indices
                    return new int[]{i, j};

                }

            }

        }

        // No valid pair found
        return new int[]{-1, -1};

    }

    public static void main(String[] args) {

        // Sample input
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Call the solution
        int[] result = TwoSum(nums, target);

        // Print the result
        System.out.println("Index 1 : " + result[0]);
        System.out.println("Index 2 : " + result[1]);

    }

}