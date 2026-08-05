package Algorithms.BitManipulation;

/**
 * ============================================================
 * Problem            : Toggle i-th Bit
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

public class ToggleIthBit {

    /**
     * Toggles the B-th bit of the given number.
     * If the bit is set, it becomes unset.
     * If the bit is unset, it becomes set.
     *
     * @param number Input number
     * @param bitPosition Zero-based bit position
     * @return Number after toggling the specified bit
     */
    public static int solve(int number, int bitPosition) {

        // Toggle the specified bit using XOR
        return number ^ (1 << bitPosition);
    }

    public static void main(String[] args) {

        // Sample input
        int number = 10;      // Binary: 1010
        int bitPosition = 1;

        // Calling the solution
        int result = solve(number, bitPosition);

        // Printing output
        System.out.println("Result: " + result);
    }
}