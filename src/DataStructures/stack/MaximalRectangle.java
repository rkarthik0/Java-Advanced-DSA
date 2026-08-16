import java.util.*;

/**
 * ============================================================
 * Problem            : Maximal Rectangle
 * Created By         : Karthik R
 * Difficulty         : Hard
 *
 * Approach           : Stack + Dynamic Programming
 * Algorithm          : Largest Rectangle in Histogram
 *
 * Time Complexity    : O(n * m)
 * Space Complexity   : O(m)
 *
 * Idea:
 * Treat every row as the base of a histogram.
 *
 * For each row:
 *
 * 1. Update the height of every column.
 *    - If A[i][j] == 1, increase the height.
 *    - If A[i][j] == 0, reset the height to 0.
 *
 * 2. Find the largest rectangle in the resulting histogram.
 *
 * The largest rectangle among all row-wise histograms is the
 * answer.
 *
 * Example:
 *
 * Matrix:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Histogram heights after each row are processed and the
 * largest histogram rectangle gives the maximal rectangle
 * of 1s.
 * ============================================================
 */

public class MaximalRectangle {

    public static int maximalRectangle(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        // heights[j] = consecutive number of 1s
        // ending at the current row for column j.
        int[] heights = new int[m];

        int maxArea = 0;

        // Process every row
        for (int i = 0; i < n; i++) {

            // Build histogram for the current row
            for (int j = 0; j < m; j++) {

                if (A[i][j] == 1) {
                    heights[j]++;
                } else {
                    // A zero breaks the consecutive sequence
                    heights[j] = 0;
                }
            }

            // Find largest rectangle in current histogram
            maxArea = Math.max(
                    maxArea,
                    largestRectangle(heights)
            );
        }

        return maxArea;
    }

    /**
     * Finds the largest rectangle in a histogram.
     *
     * Uses a monotonic increasing stack of indices.
     */
    private static int largestRectangle(int[] heights) {

        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;
        int n = heights.length;

        /*
         * Iterate one extra position.
         *
         * At i == n, currentHeight is treated as 0.
         * This forces all remaining histogram bars in the
         * stack to be processed.
         */
        for (int i = 0; i <= n; i++) {

            int currentHeight =
                    (i == n) ? 0 : heights[i];

            /*
             * If current height is smaller than the height
             * at the stack top, the taller bar can no longer
             * extend to the right.
             */
            while (!stack.isEmpty()
                    && currentHeight < heights[stack.peek()]) {

                int height = heights[stack.pop()];

                int width;

                if (stack.isEmpty()) {

                    // Rectangle extends from index 0 to i - 1
                    width = i;

                } else {

                    // Stack top is the nearest smaller bar
                    width = i - stack.peek() - 1;
                }

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            /*
             * Do not push i when i == n because n is only
             * the sentinel position.
             */
            if (i < n) {
                stack.push(i);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };

        int result = maximalRectangle(matrix);

        System.out.println("Maximum Rectangle Area: " + result);
    }
}