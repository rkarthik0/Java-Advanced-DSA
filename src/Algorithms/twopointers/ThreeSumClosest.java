package Algorithms.TwoPointers;

import java.util.Arrays;

/**
 * ============================================================
 * Problem            : 3Sum Closest
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/3sum-closest/
 * Difficulty         : Medium
 *
 * Approach           : Sorting + Two Pointers
 * Algorithm          : Two Pointer Technique
 *
 * Time Complexity    : O(n²)
 * Space Complexity   : O(log n) - Sorting stack space
 * ============================================================
 */

public class ThreeSumClosest {

    /**
     * Finds three numbers whose sum is closest to the target.
     *
     * @param nums Input array
     * @param target Target sum
     * @return Sum closest to the target
     */
    public static int threeSumClosest(int[] nums, int target) {

        // Sort the array to apply the two-pointer technique
        Arrays.sort(nums);

        int n = nums.length;

        // Initialize with the first possible triplet
        int closest = nums[0] + nums[1] + nums[2];

        // Fix the first element
        for (int i = 0; i < n - 2; i++) {

            // Two pointers for the remaining two elements
            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int currentSum = nums[i] + nums[left] + nums[right];

                // Update closest sum if current sum is better
                if (Math.abs(currentSum - target) <
                        Math.abs(closest - target)) {

                    closest = currentSum;
                }

                // Exact target found
                if (currentSum == target) {
                    return currentSum;
                }

                // Need a larger sum
                else if (currentSum < target) {
                    left++;
                }

                // Need a smaller sum
                else {
                    right--;
                }
            }
        }

        return closest;
    }

    public static void main(String[] args) {

        // Sample input
        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        // Calling the solution
        int result = threeSumClosest(nums, target);

        // Printing output
        System.out.println("Closest Sum: " + result);
    }
}