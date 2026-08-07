package Algorithms.TwoPointers;

import java.util.Arrays;

/**
 * ============================================================
 * Problem            : Two Sum
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/two-sum/
 * Difficulty         : Easy
 *
 * Approach           : Sorting + Two Pointers
 * Algorithm          : Two Pointer Technique
 *
 * Time Complexity    : O(n log n)
 * Space Complexity   : O(log n) - Sorting stack space
 * ============================================================
 */

public class TwoSum {

    /**
     * Checks whether two elements in the array add up to A.
     *
     * @param target Target sum
     * @param nums Input array
     * @return 1 if a pair exists, otherwise 0
     */
    public static int solve(int target, int[] nums) {

        // Sort the array so two pointers can be used
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        // Search for a pair using two pointers
        while (left < right) {

            int sum = nums[left] + nums[right];

            // Required pair found
            if (sum == target) {
                return 1;
            }

            // Sum is too small, move left pointer forward
            else if (sum < target) {
                left++;
            }

            // Sum is too large, move right pointer backward
            else {
                right--;
            }
        }

        // No valid pair found
        return 0;
    }

    public static void main(String[] args) {

        // Sample input
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Calling the solution
        int result = solve(target, nums);

        // Printing output
        System.out.println("Pair Exists: " + result);
    }
}