/**
 * ============================================================
 * Problem            : Sum of Maximum and Minimum
 * Created By         : Karthik R
 *
 * Approach           : Linear Traversal
 * Algorithm          : Find Minimum and Maximum
 *
 * Time Complexity    : O(N)
 * Space Complexity   : O(1)
 *
 * Idea:
 * - Traverse the array once.
 * - Keep track of the minimum and maximum values.
 * - Return min + max.
 * ============================================================
 */

public class SumMinMax {

    public int solve(int[] A) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {

            // Update maximum
            if (A[i] > max) {
                max = A[i];
            }

            // Update minimum
            if (A[i] < min) {
                min = A[i];
            }
        }

        return max + min;
    }

    public static void main(String[] args) {

        SumMinMax obj = new SumMinMax();

        int[] A = {3, 5, 1, 7, 2};

        System.out.println(obj.solve(A));
    }
}