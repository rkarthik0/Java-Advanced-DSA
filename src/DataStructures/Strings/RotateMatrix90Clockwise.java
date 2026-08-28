/**
 * ============================================================
 * Problem            : Rotate Matrix 90 Degrees Clockwise
 * Category           : Algorithms.Matrix
 * Created By         : Karthik R
 *
 * Approach           : Transpose + Reverse Each Row
 * Algorithm          : In-place Matrix Rotation
 *
 * Time Complexity    : O(N^2)
 * Space Complexity   : O(1)
 *
 * Idea:
 * 1. Transpose the matrix.
 * 2. Reverse every row.
 *
 * This rotates the matrix 90 degrees clockwise in-place.
 * ============================================================
 */

public class RotateMatrix90Clockwise {

    public void solve(int[][] A) {

        int n = A.length;

        // Step 1: Transpose the matrix.
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }

        // Step 2: Reverse every row.
        for (int i = 0; i < n; i++) {

            int l = 0;
            int r = n - 1;

            while (l < r) {

                int temp = A[i][l];
                A[i][l] = A[i][r];
                A[i][r] = temp;

                l++;
                r--;
            }
        }
    }

    public static void main(String[] args) {

        RotateMatrix90Clockwise obj =
                new RotateMatrix90Clockwise();

        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        obj.solve(A);

        for (int[] row : A) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}