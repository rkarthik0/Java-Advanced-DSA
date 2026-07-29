package DataStructures.hashmap;

import java.util.HashSet;

/**
 * ============================================================
 * Problem            : Pair Sum
 * Platform           : InterviewBit
 * Link               : https://www.interviewbit.com/problems/pair-sum/
 * Similar LeetCode   : https://leetcode.com/problems/two-sum/
 * Difficulty         : Easy
 *
 * Approach           : Hashing
 * Algorithm          : HashSet Lookup
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class PairSum {

    /**
     * Checks whether there exists a pair whose sum equals the target.
     *
     * @param target Target sum
     * @param nums Input array
     * @return 1 if a valid pair exists, otherwise 0
     */
    public static int solve(int target, int[] nums) {

        // Stores the elements seen so far
        HashSet<Integer> set = new HashSet<>();

        // Traverse the array
        for (int num : nums) {

            // Find the required complement
            int complement = target - num;

            // If complement already exists, pair is found
            if (set.contains(complement)) {
                return 1;
            }

            // Store the current element
            set.add(num);
        }

        // No valid pair found
        return 0;
    }

    public static void main(String[] args) {

        // Sample input
        int target = 8;
        int[] nums = {3, 5, 1, 2};

        // Calling the solution
        int result = solve(target, nums);

        // Printing output
        System.out.println("Pair Exists: " + result);
    }
}