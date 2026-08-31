/**
 * ============================================================
 * Problem            : Kth Perfect Number
 * Category           : Algorithms.Math
 * Created By         : Karthik R
 *
 * Approach           : Binary Representation
 *
 * Time Complexity    : O(log A)
 * Space Complexity   : O(log A)
 *
 * Idea:
 * - Perfect numbers here are even-length palindromes containing
 *   only digits 1 and 2.
 *
 * - For a first half of length len, there are 2^len numbers.
 *
 * - Each bit determines one digit:
 *      0 -> 1
 *      1 -> 2
 *
 * - Generate the first half and append its reverse.
 * ============================================================
 */

public class KthPerfectNumber {

    public String solve(int A) {

        // Convert A from 1-based index to 0-based index.
        A--;

        int len = 1;

        /*
         * Find which first-half length contains
         * the A-th number.
         *
         * len = 1 -> 2 numbers
         * len = 2 -> 4 numbers
         * len = 3 -> 8 numbers
         * ...
         */
        while (A >= (1 << len)) {

            A -= (1 << len);
            len++;
        }

        StringBuilder firstHalf =
                new StringBuilder();

        /*
         * Generate the first half using binary representation.
         *
         * Bit 0 -> digit 1
         * Bit 1 -> digit 2
         */
        for (int i = len - 1; i >= 0; i--) {

            if ((A & (1 << i)) == 0) {
                firstHalf.append('1');
            } else {
                firstHalf.append('2');
            }
        }

        /*
         * Mirror the first half.
         *
         * Example:
         * firstHalf = "12"
         * reverse   = "21"
         *
         * result = "1221"
         */
        StringBuilder result =
                new StringBuilder(firstHalf);

        result.append(
                new StringBuilder(firstHalf).reverse()
        );

        return result.toString();
    }

    public static void main(String[] args) {

        KthPerfectNumber obj =
                new KthPerfectNumber();

        // First few perfect numbers:
        // 1 -> 11
        // 2 -> 22
        // 3 -> 1111
        // 4 -> 1221
        // 5 -> 2112
        // 6 -> 2222

        int A = 5;

        System.out.println(obj.solve(A));
    }
}