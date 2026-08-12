/**
 * ============================================================
 * Problem            : Number of 1 Bits
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/number-of-1-bits/
 * Difficulty         : Easy
 *
 * Approach           : Bit Manipulation
 * Algorithm          : Brian Kernighan's Algorithm
 *
 * Time Complexity    : O(k)
 * Space Complexity   : O(1)
 *
 * Where k = number of set bits in A.
 * ============================================================
 */

public class NumberOf1Bits {

    /**
     * Counts the number of set bits (1s) in the binary
     * representation of A.
     *
     * Key idea:
     * A & (A - 1) removes the rightmost set bit.
     */
    public static int numSetBits(int A) {

        int count = 0;

        while (A != 0) {

            // Removes the rightmost set bit
            A = A & (A - 1);

            count++;
        }

        return count;
    }

    public static void main(String[] args) {

        int A = 11;

        int result = numSetBits(A);

        System.out.println("Number of Set Bits: " + result);
    }
}