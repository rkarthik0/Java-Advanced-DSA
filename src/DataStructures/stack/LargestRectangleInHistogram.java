package DataStructures.Stack;

import java.util.Stack;

/**
 * ============================================================
 * Problem            : Largest Rectangle in Histogram
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/largest-rectangle-in-histogram/
 * Difficulty         : Hard
 *
 * Approach           : Monotonic Increasing Stack
 * Algorithm          : Stack
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class LargestRectangleInHistogram {

    /**
     * Finds the largest rectangular area in a histogram.
     *
     * @param heights Array representing histogram heights
     * @return Maximum rectangular area
     */
    public static int largestRectangleArea(int[] heights) {

        // Stores the maximum area found
        int maxArea = 0;

        int n = heights.length;

        // Stores indices of histogram bars
        Stack<Integer> stack = new Stack<>();

        // Traverse all histogram bars
        for (int i = 0; i < n; i++) {

            // Process bars higher than the current bar
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {

                int height = heights[stack.pop()];
                int width;

                // If stack becomes empty, rectangle extends from index 0
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }

            // Push current index
            stack.push(i);
        }

        // Process remaining bars in the stack
        while (!stack.isEmpty()) {

            int height = heights[stack.pop()];
            int width;

            if (stack.isEmpty()) {
                width = n;
            } else {
                width = n - stack.peek() - 1;
            }

            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {

        // Sample input
        int[] heights = {2, 1, 5, 6, 2, 3};

        // Calling the solution
        int result = largestRectangleArea(heights);

        // Printing output
        System.out.println("Largest Rectangle Area: " + result);
    }
}