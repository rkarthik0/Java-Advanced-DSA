package DataStructures.Heap;

import java.util.PriorityQueue;

/**
 * ============================================================
 * Problem            : Connect Ropes
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/minimum-cost-to-connect-sticks/
 * Difficulty         : Medium
 *
 * Approach           : Greedy
 * Algorithm          : Min Heap (Priority Queue)
 *
 * Time Complexity    : O(n log n)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class ConnectRopes {

    /**
     * Finds the minimum total cost required to connect all ropes.
     *
     * @param ropes Array containing the lengths of the ropes
     * @return Minimum total cost
     */
    public static int solve(int[] ropes) {

        // Min Heap to always fetch the two smallest ropes
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert all rope lengths into the heap
        for (int rope : ropes) {
            minHeap.offer(rope);
        }

        int totalCost = 0;

        // Continue until only one rope remains
        while (minHeap.size() > 1) {

            // Remove the two smallest ropes
            int first = minHeap.poll();
            int second = minHeap.poll();

            // Cost of connecting them
            int cost = first + second;

            // Add the cost to the total
            totalCost += cost;

            // Insert the newly formed rope back into the heap
            minHeap.offer(cost);
        }

        return totalCost;
    }

    public static void main(String[] args) {

        // Sample input
        int[] ropes = {2, 4, 3, 6};

        // Calling the solution
        int result = solve(ropes);

        // Printing output
        System.out.println("Minimum Total Cost: " + result);
    }
}