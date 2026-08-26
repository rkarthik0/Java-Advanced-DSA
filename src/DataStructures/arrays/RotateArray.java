/**
 * ============================================================
 * Problem            : Rotate Array
 * Created By         : Karthik R
 *
 * Approach           : Array Reversal
 * Algorithm          : Reversal Algorithm
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(1)
 *
 * Idea:
 * - Reduce B using B % N.
 * - Reverse the complete array.
 * - Reverse the first B elements.
 * - Reverse the remaining elements.
 *
 * Example:
 * A = [1, 2, 3, 4, 5]
 * B = 2
 *
 * Step 1: Reverse whole array
 * [5, 4, 3, 2, 1]
 *
 * Step 2: Reverse first B elements
 * [4, 5, 3, 2, 1]
 *
 * Step 3: Reverse remaining elements
 * [4, 5, 1, 2, 3]
 * ============================================================
 */

public class RotateArray {

    public int[] solve(int[] A, int B) {

        int n = A.length;

        // Handle B greater than array length.
        B = B % n;

        // Reverse the entire array.
        reverse(A, 0, n - 1);

        // Reverse the first B elements.
        reverse(A, 0, B - 1);

        // Reverse the remaining elements.
        reverse(A, B, n - 1);

        return A;
    }

    private void reverse(int[] A, int start, int end) {

        while (start < end) {

            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        RotateArray obj = new RotateArray();

        int[] A = {1, 2, 3, 4, 5};
        int B = 2;

        int[] result = obj.solve(A, B);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}