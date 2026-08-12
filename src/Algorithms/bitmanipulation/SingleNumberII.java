/**
 * ============================================================
 * Problem            : Single Number II
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/single-number-ii/
 * Difficulty         : Medium
 *
 * Approach           : Bit Manipulation
 * Algorithm          : Bit Counting
 *
 * Time Complexity    : O(32 * n) = O(n)
 * Space Complexity   : O(1)
 *
 * Idea:
 * Every number appears exactly 3 times except one number.
 * For each of the 32 bits, count how many numbers have that
 * bit set.
 *
 * If count % 3 == 1, that bit belongs to the unique number.
 * ============================================================
 */

public class SingleNumberII {

    public static int singleNumber(int[] A) {

        int n = A.length;
        int answer = 0;

        // Check every bit position from 0 to 31
        for (int i = 0; i < 32; i++) {

            int count = 0;

            // Count numbers having the current bit set
            for (int j = 0; j < n; j++) {

                if (checkBit(A[j], i)) {
                    count++;
                }
            }

            // Bits occurring 1 time after removing groups of 3
            // belong to the unique number.
            if (count % 3 == 1) {
                answer = answer | (1 << i);
            }
        }

        return answer;
    }

    /**
     * Checks whether the ith bit is set in A.
     */
    private static boolean checkBit(int A, int i) {

        return (A & (1 << i)) != 0;
    }

    public static void main(String[] args) {

        int[] A = {2, 2, 3, 2};

        int result = singleNumber(A);

        System.out.println("Single Number: " + result);
    }
}