package datastructures.arrays;

/**
 * ============================================================
 * Problem            : Sum of All Submatrices
 * Platform           : InterviewBit
 * Link               : https://www.interviewbit.com/problems/sum-of-all-submatrices/
 * Difficulty         : Medium
 *
 * Approach           : Contribution Technique
 * Algorithm          : Element Contribution
 *
 * Time Complexity    : O(N × M)
 * Space Complexity   : O(1)
 * ============================================================
 */

public class SumOfAllSubMatrices {

    /**
     * Calculates the sum of all possible submatrices.
     *
     * @param A Input matrix
     * @return Sum of all submatrices
     */
    public static int solve(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        // Stores the final answer
        int sum = 0;

        // Traverse every element of the matrix
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                // Number of ways to choose the top-left corner
                int top = (i + 1) * (j + 1);

                // Number of ways to choose the bottom-right corner
                int bottom = (n - i) * (m - j);

                // Contribution of the current element
                int contribution = top * bottom * A[i][j];

                // Add its contribution
                sum += contribution;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        // Sample input
        int[][] A = {
                {1, 1},
                {1, 1}
        };

        // Calling the solution
        int result = solve(A);

        // Printing output
        System.out.println("Sum of All Submatrices: " + result);
    }
}