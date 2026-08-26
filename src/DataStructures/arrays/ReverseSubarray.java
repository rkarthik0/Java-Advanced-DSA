/**
 * ============================================================
 * Problem            : Reverse Array From B to C
 * Created By         : Karthik R
 *
 * Approach           : Two Pointers
 * Algorithm          : In-place Reversal
 *
 * Time Complexity    : O(C - B + 1)
 * Space Complexity   : O(1)
 *
 * Idea:
 * - Use two pointers:
 *   B -> start of the subarray
 *   C -> end of the subarray
 * - Swap both elements.
 * - Move B forward and C backward.
 * - Continue until the pointers meet.
 * ============================================================
 */

public class ReverseSubarray {

    public int[] solve(int[] A, int B, int C) {

        while (B < C) {

            // Swap elements at B and C.
            int temp = A[B];
            A[B] = A[C];
            A[C] = temp;

            // Move pointers toward the center.
            B++;
            C--;
        }

        return A;
    }

    public static void main(String[] args) {

        ReverseSubarray obj = new ReverseSubarray();

        int[] A = {1, 2, 3, 4, 5};
        int B = 1;
        int C = 3;

        int[] result = obj.solve(A, B, C);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}