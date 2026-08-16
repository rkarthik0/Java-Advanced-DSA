import java.util.*;

/**
 * ============================================================
 * Problem            : Sliding Window Maximum
 * Created By         : Karthik R
 * Difficulty         : Medium
 *
 * Approach           : Deque
 * Algorithm          : Monotonic Decreasing Deque
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(B)
 *
 * Idea:
 * For every window of size B, find the maximum element.
 *
 * A brute-force approach would take O(n * B).
 *
 * Instead, maintain a deque containing indices of useful
 * elements in decreasing order of their values.
 *
 * The front of the deque always contains the index of the
 * maximum element of the current window.
 *
 * For every new element:
 *
 * 1. Remove indices that are outside the current window.
 * 2. Remove smaller elements from the back because they can
 *    never become the maximum while the current element exists.
 * 3. Add the current index.
 * 4. The front gives the maximum of the current window.
 * ============================================================
 */

public class SlidingWindowMaximum {

    public static int[] slidingMaximum(final int[] A, int B) {

        int n = A.length;

        // Deque stores indices, not values.
        // Values corresponding to these indices are maintained
        // in decreasing order.
        Deque<Integer> deque = new ArrayDeque<>();

        // If the window size is greater than the array size,
        // there is only one possible window containing the
        // complete array.
        if (n < B) {

            int max = Integer.MIN_VALUE;

            for (int value : A) {
                max = Math.max(max, value);
            }

            return new int[]{max};
        }

        int[] answer = new int[n - B + 1];

        // ========================================================
        // STEP 1: Process the first window
        // ========================================================

        for (int i = 0; i < B; i++) {

            // Remove smaller elements from the back.
            //
            // They cannot become the maximum as long as A[i]
            // remains inside the window.
            while (!deque.isEmpty()
                    && A[i] > A[deque.peekLast()]) {

                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);
        }

        // Front contains the index of the maximum element
        // of the first window.
        answer[0] = A[deque.peekFirst()];

        // ========================================================
        // STEP 2: Process remaining windows
        // ========================================================

        int index = 1;

        for (int i = B; i < n; i++) {

            // ----------------------------------------------------
            // Remove indices that have moved outside the window.
            //
            // Current window:
            // [i - B + 1 ... i]
            // ----------------------------------------------------
            while (!deque.isEmpty()
                    && deque.peekFirst() <= i - B) {

                deque.pollFirst();
            }

            // ----------------------------------------------------
            // Maintain decreasing order of values.
            // ----------------------------------------------------
            while (!deque.isEmpty()
                    && A[i] > A[deque.peekLast()]) {

                deque.pollLast();
            }

            // Add current element
            deque.offerLast(i);

            // Maximum of current window
            answer[index++] = A[deque.peekFirst()];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] A = {1, 3, -1, -3, 5, 3, 6, 7};

        int B = 3;

        int[] result = slidingMaximum(A, B);

        System.out.println("Sliding Window Maximum:");
        System.out.println(Arrays.toString(result));
    }
}