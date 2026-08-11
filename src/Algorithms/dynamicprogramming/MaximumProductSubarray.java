import java.util.*;

/**
 * ============================================================
 * Problem            : Maximum Product Subarray
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/maximum-product-subarray/
 * Difficulty         : Medium
 *
 * Approach           : Dynamic Programming
 * Algorithm          : Bottom-Up DP (Tabulation)
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class MaximumProductSubarray {

    /**
     * Finds the maximum product of a contiguous subarray.
     *
     * We maintain both maximum and minimum products ending
     * at every index because multiplying by a negative number
     * can turn the minimum product into the maximum product.
     *
     * @param nums Input array
     * @return Maximum product of a contiguous subarray
     */
    public static int maxProduct(int[] nums) {

        int n = nums.length;

        int[] max = new int[n];
        int[] min = new int[n];

        // Base case
        max[0] = nums[0];
        min[0] = nums[0];

        // Calculate maximum and minimum product ending at each index
        for (int i = 1; i < n; i++) {

            int current = nums[i];

            // Three possibilities:
            // 1. Start a new subarray
            // 2. Extend previous maximum
            // 3. Extend previous minimum
            int first = current;
            int second = current * max[i - 1];
            int third = current * min[i - 1];

            // Maximum product ending at index i
            max[i] = Math.max(
                    first,
                    Math.max(second, third)
            );

            // Minimum product ending at index i
            min[i] = Math.min(
                    first,
                    Math.min(second, third)
            );
        }

        // Maximum product can end at any index
        int answer = max[0];

        for (int i = 1; i < n; i++) {
            answer = Math.max(answer, max[i]);
        }

        return answer;
    }

    public static void main(String[] args) {

        // Sample input
        int[] nums = {2, 3, -2, 4};

        // Calling the solution
        int result = maxProduct(nums);

        // Printing output
        System.out.println("Maximum Product: " + result);
    }
}