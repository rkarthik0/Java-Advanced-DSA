package Algorithms.BinarySearch;

/**
 * ============================================================
 * Problem            : Search a 2D Matrix
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/search-a-2d-matrix/
 * Difficulty         : Medium
 *
 * Approach           : Binary Search
 * Algorithm          : Binary Search on Virtual 1D Array
 *
 * Time Complexity    : O(log(n × m))
 * Space Complexity   : O(1)
 * ============================================================
 */

public class SearchA2DMatrix {

    /**
     * Searches for a target value in a sorted 2D matrix.
     *
     * @param matrix Input 2D matrix
     * @param target Target value
     * @return 1 if target exists, otherwise 0
     */
    public static int searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Consider the 2D matrix as a virtual 1D sorted array
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Convert the virtual 1D index back to 2D indices
            int row = mid / cols;
            int col = mid % cols;

            // Target found
            if (matrix[row][col] == target) {
                return 1;
            }

            // Search in the right half
            else if (matrix[row][col] < target) {
                left = mid + 1;
            }

            // Search in the left half
            else {
                right = mid - 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        // Sample input
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 16;

        // Calling the solution
        int result = searchMatrix(matrix, target);

        // Printing output
        System.out.println("Target Found: " + result);
    }
}