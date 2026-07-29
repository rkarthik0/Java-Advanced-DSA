package Algorithms.bitmanipulation;

/**
 * ============================================================
 * Problem            : Number of 1 Bits
 * Platform           : LeetCode
 * Link               : https://leetcode.com/problems/number-of-1-bits/
 * Difficulty         : Easy
 *
 * Approach           : Brian Kernighan's Algorithm
 * Algorithm          : Bit Manipulation
 *
 * Time Complexity    : O(k), where k is the number of set bits
 * Space Complexity   : O(1)
 * ============================================================
 */

public class NumberOfSetBits {

    /**
     * Counts the number of set bits (1's) in the binary
     * representation of the given integer.
     *
     * @param number Input integer
     * @return Number of set bits
     */
    public static int numSetBits(int number) {

        // Stores the count of set bits
        int count = 0;

        // Remove the rightmost set bit in each iteration
        while (number != 0) {

            number = number & (number - 1);

            count++;
        }

        return count;
    }

    public static void main(String[] args) {

        // Sample input
        int number = 11;

        // Calling the solution
        int result = numSetBits(number);

        // Printing output
        System.out.println("Number of Set Bits: " + result);
    }
}
