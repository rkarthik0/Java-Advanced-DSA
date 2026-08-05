package Algorithms.BitManipulation;

/**
 * ============================================================
 * Problem            : Set Bit
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

public class SetBit {

    /**
     * Sets the A-th and B-th bits in a number initially equal to 0.
     *
     * @param firstBit Zero-based position of the first bit
     * @param secondBit Zero-based position of the second bit
     * @return Number after setting both bits
     */
    public static int solve(int firstBit, int secondBit) {

        // Initialize the number
        int number = 0;

        // Set the first bit
        number |= (1 << firstBit);

        // Set the second bit
        number |= (1 << secondBit);

        return number;
    }

    public static void main(String[] args) {

        // Sample input
        int firstBit = 1;
        int secondBit = 3;

        // Calling the solution
        int result = solve(firstBit, secondBit);

        // Printing output
        System.out.println("Result: " + result);
    }
}