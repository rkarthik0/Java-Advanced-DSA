package Algorithms.BitManipulation;

/**
 * ============================================================
 * Problem            : Single Number III
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/single-number-iii/
 * Difficulty         : Medium
 *
 * Approach           : XOR Partitioning
 * Algorithm          : Bit Manipulation
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(1)
 * ============================================================
 */

public class SingleNumberIII {

    /**
     * Finds the two numbers that appear only once,
     * while every other number appears exactly twice.
     *
     * @param nums Input array
     * @return Array containing the two unique numbers in ascending order
     */
    public static int[] solve(int[] nums) {

        // XOR of all elements gives XOR of the two unique numbers
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        // Find the rightmost set bit where the two numbers differ
        int differingBit = xor & (-xor);

        int first = 0;
        int second = 0;

        // Divide numbers into two groups based on the differing bit
        for (int num : nums) {

            if ((num & differingBit) != 0) {
                first ^= num;
            } else {
                second ^= num;
            }
        }

        // Return the result in ascending order
        return (first < second)
                ? new int[]{first, second}
                : new int[]{second, first};
    }

    public static void main(String[] args) {

        // Sample input
        int[] nums = {1, 2, 1, 3, 2, 5};

        // Calling the solution
        int[] result = solve(nums);

        // Printing output
        System.out.println("First Unique Number : " + result[0]);
        System.out.println("Second Unique Number: " + result[1]);
    }
}