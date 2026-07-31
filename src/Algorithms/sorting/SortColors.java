package Algorithms.sorting;

/**
 * ============================================================
 * Problem            : Sort Colors
 * Platform           : LeetCode
 * Link               : https://leetcode.com/problems/sort-colors/
 * Difficulty         : Medium
 *
 * Approach           : Three Pointers
 * Algorithm          : Dutch National Flag Algorithm
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(1)
 * ============================================================
 */

public class SortColors {

    /**
     * Sorts an array containing only 0s, 1s, and 2s.
     *
     * @param nums Input array
     * @return Sorted array
     */
    public static int[] sortColors(int[] nums) {

        // Pointer for placing 0s
        int zero = 0;

        // Pointer for placing 2s
        int two = nums.length - 1;

        // Current pointer
        int i = 0;

        while (i <= two) {

            // Place 0 at the beginning
            if (nums[i] == 0) {

                int temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;

                zero++;
                i++;
            }

            // Place 2 at the end
            else if (nums[i] == 2) {

                int temp = nums[two];
                nums[two] = nums[i];
                nums[i] = temp;

                two--;
            }

            // 1 is already in the correct region
            else {
                i++;
            }
        }

        return nums;
    }

    public static void main(String[] args) {

        // Sample input
        int[] nums = {2, 0, 2, 1, 1, 0};

        // Calling the solution
        int[] result = sortColors(nums);

        // Printing output
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}