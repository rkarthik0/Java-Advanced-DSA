package Algorithms.BinarySearch;

/**
 * ============================================================
 * Problem            : Find a Peak Element
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/find-peak-element/
 * Difficulty         : Medium
 *
 * Approach           : Binary Search
 * Algorithm          : Binary Search
 *
 * Time Complexity    : O(log n)
 * Space Complexity   : O(1)
 * ============================================================
 */

public class FindPeakElement {

    /**
     * Finds and returns any peak element in the array.
     * A peak element is greater than or equal to its adjacent elements.
     *
     * @param nums Input array
     * @return Peak element
     */
    public static int solve(int[] nums) {

        int n = nums.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Check if current element is a peak
            if ((mid == 0 || nums[mid] >= nums[mid - 1]) &&
                    (mid == n - 1 || nums[mid] >= nums[mid + 1])) {

                return nums[mid];
            }

            // Peak lies on the right side
            else if (mid == 0 || nums[mid] > nums[mid - 1]) {
                left = mid + 1;
            }

            // Peak lies on the left side
            else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        // Sample input
        int[] nums = {1, 3, 20, 4, 1, 0};

        // Calling the solution
        int result = solve(nums);

        // Printing output
        System.out.println("Peak Element: " + result);
    }
}