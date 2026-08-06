package DataStructures.Heap;

import java.util.PriorityQueue;

/**
 * ============================================================
 * Problem            : Misha and Candies
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Medium
 *
 * Approach           : Greedy
 * Algorithm          : Min Heap (Priority Queue)
 *
 * Time Complexity    : O(n log n)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class MishaAndCandies {

    /**
     * Calculates the total number of candies eaten by Misha.
     *
     * Rules:
     * - Always choose the box with the minimum candies.
     * - If its candies are greater than B, stop.
     * - Misha eats floor(candies / 2).
     * - The remaining candies are added to the next minimum box.
     *
     * @param candies Array containing candies in each box
     * @param limit Maximum candies allowed in the chosen box
     * @return Total candies eaten by Misha
     */
    public static int solve(int[] candies, int limit) {

        // Min Heap to always access the smallest box
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert all boxes into the heap
        for (int candy : candies) {
            minHeap.offer(candy);
        }

        int totalEaten = 0;

        // Continue while a valid box exists
        while (!minHeap.isEmpty() && minHeap.peek() <= limit) {

            // Remove the box with the minimum candies
            int smallest = minHeap.poll();

            // Misha eats half the candies (floor value)
            int eaten = smallest / 2;
            totalEaten += eaten;

            // Remaining candies
            int remaining = smallest - eaten;

            // Add remaining candies to the next minimum box
            if (!minHeap.isEmpty()) {

                int secondSmallest = minHeap.poll();

                secondSmallest += remaining;

                minHeap.offer(secondSmallest);
            }
        }

        return totalEaten;
    }

    public static void main(String[] args) {

        // Sample input
        int[] candies = {3, 2, 3};
        int limit = 4;

        // Calling the solution
        int result = solve(candies, limit);

        // Printing output
        System.out.println("Total Candies Eaten: " + result);
    }
}