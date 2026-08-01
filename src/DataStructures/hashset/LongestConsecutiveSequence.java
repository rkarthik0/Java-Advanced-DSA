package DataStructures.hashset;
import java.util.HashSet;

/**
 * ============================================================
 * Problem            : Longest Consecutive Sequence
 * Platform           : LeetCode
 * Link               : https://leetcode.com/problems/longest-consecutive-sequence/
 * Difficulty         : Medium
 *
 * Approach           : HashSet
 * Algorithm          : Sequence Expansion
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class LongestConsecutiveSequence {

    /**
     * Finds the length of the longest consecutive sequence.
     *
     * @param nums Input array
     * @return Length of the longest consecutive sequence
     */
    public static int longestConsecutive(int[] nums) {

        // Stores all unique elements
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // Stores the maximum sequence length
        int maxLength = 0;

        // Traverse each element
        for (int num : nums) {

            // Start a new sequence only if previous element doesn't exist
            if (!set.contains(num - 1)) {

                int current = num;
                int length = 1;

                // Expand the consecutive sequence
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                // Update maximum length
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        // Sample input
        int[] nums = {100, 4, 200, 1, 3, 2};

        // Calling the solution
        int result = longestConsecutive(nums);

        // Printing output
        System.out.println("Longest Consecutive Sequence Length: " + result);
    }
}
