package Algorithms.BinarySearch;

/**
 * ============================================================
 * Problem            : Search Insert Position
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/search-insert-position/
 * Difficulty         : Easy
 *
 * Approach           : Binary Search
 * Algorithm          : Binary Search
 *
 * Time Complexity    : O(log n)
 * Space Complexity   : O(1)
 * ============================================================
 */

public class SearchInsertPosition {

    /**
     * Returns the index if the target exists,
     * otherwise returns the position where it should be inserted.
     *
     * @param nums Sorted input array
     * @param target Target value
     * @return Index of target or insertion position
     */
    public static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        // Perform binary search
        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            // Search in the right half
            else if (nums[mid] < target) {
                left = mid + 1;
            }

            // Search in the left half
            else {
                right = mid - 1;
            }
        }

        // 'left' is the correct insertion position
        return left;
    }

    public static void main(String[] args) {

        // Sample input
        int[] nums = {1, 3, 5, 6};
        int target = 2;

        // Calling the solution
        int result = searchInsert(nums, target);

        // Printing output
        System.out.println("Insert Position: " + result);
    }
}