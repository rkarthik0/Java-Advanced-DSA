import java.util.*;

/**
 * ============================================================
 * Problem            : Running Median
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Medium
 *
 * Approach           : Heap / Priority Queue
 * Algorithm          : Two Heaps
 *
 * Time Complexity    : O(n log n)
 * Space Complexity   : O(n)
 *
 * Idea:
 * - Max Heap stores the smaller half of the elements.
 * - Min Heap stores the larger half of the elements.
 * - Max Heap is kept equal in size to Min Heap or
 *   at most one element larger.
 *
 * The maximum element of the smaller half is the median.
 * ============================================================
 */

public class RunningMedian {

    public static int[] solve(int[] A) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Max Heap for the smaller half
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        int[] ans = new int[A.length];

        // First element
        maxHeap.offer(A[0]);
        ans[0] = A[0];

        for (int i = 1; i < A.length; i++) {

            // Insert into the appropriate heap
            if (A[i] < maxHeap.peek()) {
                maxHeap.offer(A[i]);
            } else {
                minHeap.offer(A[i]);
            }

            // Balance the heaps
            int diff = maxHeap.size() - minHeap.size();

            // Min Heap has one extra element
            if (diff == -1) {
                maxHeap.offer(minHeap.poll());
            }

            // Max Heap has two extra elements
            if (diff == 2) {
                minHeap.offer(maxHeap.poll());
            }

            // After balancing, the max heap contains
            // the median for the required convention.
            ans[i] = maxHeap.peek();
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4, 5};

        int[] result = solve(A);

        System.out.println(Arrays.toString(result));
    }
}