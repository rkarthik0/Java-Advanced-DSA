/**
 * ============================================================
 * Problem            : Count Set Bits
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/number-of-1-bits/
 * Difficulty         : Easy
 *
 * Approach           : Bit Manipulation
 * Algorithm          : Bit Checking
 *
 * Time Complexity    : O(32) = O(1)
 * Space Complexity   : O(1)
 * ============================================================
 */

public class CountSetBits {

    /**
     * Counts the number of set bits (1s) in the
     * 32-bit binary representation of A.
     */
    public static int solve(int A) {

        int count = 0;

        // Check all 32 bit positions
        for (int i = 0; i < 32; i++) {

            // Check whether the ith bit is set
            if ((A & (1 << i)) != 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int A = 11;

        int result = solve(A);

        System.out.println("Number of Set Bits: " + result);
    }
}