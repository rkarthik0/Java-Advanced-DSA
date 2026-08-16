import java.util.*;

/**
 * ============================================================
 * Problem            : Sum of Min and Max
 * Created By         : Karthik R
 * Difficulty         : Medium
 *
 * Approach           : Deque
 * Algorithm          : Monotonic Deque
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(B)
 *
 * Idea:
 * For every subarray of size B, calculate:
 *
 *     maximum + minimum
 *
 * We maintain two deques:
 *
 * 1. maxDeque
 *    - Stores indices in decreasing order of values.
 *    - Front contains the maximum element of the window.
 *
 * 2. minDeque
 *    - Stores indices in increasing order of values.
 *    - Front contains the minimum element of the window.
 *
 * For every new element:
 *
 * - Remove indices that are outside the current window.
 * - Remove useless elements from the back of each deque.
 * - Add the current index.
 * - Once the first window is complete, add its maximum
 *   and minimum to the answer.
 * ============================================================
 */

public class SumOfMinAndMax {

    public static int solve(int[] A, int B) {

        final long MOD = 1000000007L;

        // Decreasing deque -> maximum of current window
        Deque<Integer> maxDeque = new ArrayDeque<>();

        // Increasing deque -> minimum of current window
        Deque<Integer> minDeque = new ArrayDeque<>();

        long answer = 0;

        for (int i = 0; i < A.length; i++) {

            // ====================================================
            // Remove elements that are outside the current window
            // ====================================================

            while (!maxDeque.isEmpty()
                    && maxDeque.peekFirst() <= i - B) {

                maxDeque.pollFirst();
            }

            while (!minDeque.isEmpty()
                    && minDeque.peekFirst() <= i - B) {

                minDeque.pollFirst();
            }

            // ====================================================
            // Maintain decreasing order for maximum deque
            // ====================================================

            while (!maxDeque.isEmpty()
                    && A[maxDeque.peekLast()] <= A[i]) {

                maxDeque.pollLast();
            }

            maxDeque.offerLast(i);

            // ====================================================
            // Maintain increasing order for minimum deque
            // ====================================================

            while (!minDeque.isEmpty()
                    && A[minDeque.peekLast()] >= A[i]) {

                minDeque.pollLast();
            }

            minDeque.offerLast(i);

            // ====================================================
            // A complete window of size B is available
            // ====================================================

            if (i >= B - 1) {

                long maximum = A[maxDeque.peekFirst()];
                long minimum = A[minDeque.peekFirst()];

                answer = (answer + maximum + minimum) % MOD;
            }
        }

        return (int) answer;
    }

    public static void main(String[] args) {

        int[] A = {2, 5, -1, 7, -3, -1, -2};

        int B = 4;

        int result = solve(A, B);

        System.out.println("Sum of Minimums and Maximums: " + result);
    }
}