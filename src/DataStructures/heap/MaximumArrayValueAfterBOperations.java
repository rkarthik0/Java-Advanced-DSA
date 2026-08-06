package DataStructures.Heap;

import java.util.PriorityQueue;

/**
 * ============================================================
 * Problem            : Maximum Array Value After B Operations
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Medium
 *
 * Approach           : Greedy
 * Algorithm          : Min Heap (Priority Queue)
 *
 * Time Complexity    : O((n + B) log n)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class MaximumArrayValueAfterBOperations {

    /**
     * Performs B operations on the array and returns
     * the maximum element after all operations.
     *
     * @param nums Input array
     * @param operations Number of operations
     * @return Maximum element after all operations
     */
    public static int solve(int[] nums, int operations) {

        int n = nums.length;

        // Stores the current value of every element
        int[] currentState = nums.clone();

        // Min Heap:
        // {next value after operation, index}
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Initialize the heap
        for (int i = 0; i < n; i++) {

            // First operation changes A[i] to 2 * A[i]
            minHeap.offer(new int[]{2 * nums[i], i});
        }

        // Perform B operations
        while (operations-- > 0) {

            // Element producing the minimum next value
            int[] top = minHeap.poll();

            int nextValue = top[0];
            int index = top[1];

            // Update the current value
            currentState[index] = nextValue;

            // Push its next possible value
            minHeap.offer(new int[]{nextValue + nums[index], index});
        }

        // Find the maximum value in the final array
        int answer = currentState[0];

        for (int value : currentState) {
            answer = Math.max(answer, value);
        }

        return answer;
    }

    public static void main(String[] args) {

        // Sample input
        int[] nums = {1, 2, 3};
        int operations = 4;

        // Calling the solution
        int result = solve(nums, operations);

        // Printing output
        System.out.println("Maximum Value: " + result);
    }
}