package Algorithms.binarysearch;
/**
 * ============================================================
 * Problem            : Find First and Last Position of Element in Sorted Array
 * Platform           : LeetCode
 * Link               : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Difficulty         : Medium
 *
 * Approach           : Binary Search
 * Algorithm          : Modified Binary Search
 *
 * Time Complexity    : O(log n)
 * Space Complexity   : O(1)
 * ============================================================
 */

public class SearchRange {

    /**
     * Finds the first and last occurrence of the target element
     * in a sorted array.
     *
     * @param nums Sorted input array
     * @param target Target element
     * @return Array containing first and last occurrence indices
     */
    public static int[] searchRange(int[] nums, int target) {

        int n = nums.length;

        int left = 0;
        int right = n - 1;

        int firstOccurrence = -1;
        int lastOccurrence = -1;

        // Find the first occurrence
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                firstOccurrence = mid;

                // Continue searching on the left side
                right = mid - 1;

            } else if (nums[mid] < target) {

                // Search in the right half
                left = mid + 1;

            } else {

                // Search in the left half
                right = mid - 1;
            }
        }

        // Reset pointers to find the last occurrence
        left = 0;
        right = n - 1;

        // Find the last occurrence
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {

                lastOccurrence = mid;

                // Continue searching on the right side
                left = mid + 1;

            } else if (nums[mid] < target) {

                // Search in the right half
                left = mid + 1;

            } else {

                // Search in the left half
                right = mid - 1;
            }
        }

        return new int[]{firstOccurrence, lastOccurrence};
    }

    public static void main(String[] args) {

        // Sample input
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        // Calling the solution
        int[] result = searchRange(nums, target);

        // Printing output
        System.out.println("First Occurrence : " + result[0]);
        System.out.println("Last Occurrence  : " + result[1]);
    }
}