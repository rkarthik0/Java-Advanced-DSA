package DataStructures.Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * ============================================================
 * Problem            : Queries on a Min Heap
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Medium
 *
 * Approach           : Simulation
 * Algorithm          : Min Heap (Priority Queue)
 *
 * Time Complexity    : O(n log n)
 * Space Complexity   : O(n)
 * ============================================================
 */

public class QueriesOnMinHeap {

    /**
     * Processes heap queries.
     *
     * Query Type 1:
     * - Extract and return the minimum element.
     * - If the heap is empty, return -1.
     *
     * Query Type 2:
     * - Insert the given element into the min heap.
     *
     * @param queries List of heap queries
     * @return Results of all extract-min queries
     */
    public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> queries) {

        // Min Heap to maintain elements in ascending order
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Stores results of extract-min operations
        ArrayList<Integer> result = new ArrayList<>();

        // Process each query
        for (ArrayList<Integer> query : queries) {

            int operation = query.get(0);
            int value = query.get(1);

            // Insert operation
            if (operation == 2) {

                minHeap.offer(value);
            }

            // Extract minimum operation
            else {

                if (minHeap.isEmpty()) {

                    // Heap is empty
                    result.add(-1);

                } else {

                    // Remove and store the minimum element
                    result.add(minHeap.poll());
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        // Sample queries
        ArrayList<ArrayList<Integer>> queries = new ArrayList<>();

        queries.add(new ArrayList<>(java.util.Arrays.asList(2, 5)));
        queries.add(new ArrayList<>(java.util.Arrays.asList(2, 2)));
        queries.add(new ArrayList<>(java.util.Arrays.asList(2, 8)));
        queries.add(new ArrayList<>(java.util.Arrays.asList(1, -1)));
        queries.add(new ArrayList<>(java.util.Arrays.asList(1, -1)));
        queries.add(new ArrayList<>(java.util.Arrays.asList(1, -1)));

        // Calling the solution
        ArrayList<Integer> result = solve(queries);

        // Printing output
        System.out.println(result);
    }
}