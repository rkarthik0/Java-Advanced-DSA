package Algorithms.BitManipulation;

/**
 * ============================================================
 * Problem            : Unset i-th Bit
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Easy
 *
 * Approach           : Bit Masking
 * Algorithm          : Bit Manipulation
 *
 * Time Complexity    : O(1)
 * Space Complexity   : O(1)
 * ============================================================
 */

public class UnsetIthBit {

    /**
     * Unsets the B-th bit of the given number if it is set.
     *
     * @param number Input number
     * @param bitPosition Zero-based bit position
     * @return Number after unsetting the specified bit
     */
    public static int solve(int number, int bitPosition) {

        // Check whether the bit is set
        if ((number & (1 << bitPosition)) != 0) {

            // Unset the bit
            return number & ~(1 << bitPosition);
        }

        // Bit is already unset
        return number;
    }

    public static void main(String[] args) {

        // Sample input
        int number = 13;      // Binary: 1101
        int bitPosition = 2;

        // Calling the solution
        int result = solve(number, bitPosition);

        // Printing output
        System.out.println("Result: " + result);
    }
}