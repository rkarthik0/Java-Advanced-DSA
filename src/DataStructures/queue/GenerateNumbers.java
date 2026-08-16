import java.util.*;

/**
 * ============================================================
 * Problem            : Generate First A Numbers Using 1, 2, 3
 * Created By         : Karthik R
 * Difficulty         : Easy
 *
 * Approach           : Queue
 * Algorithm          : BFS / Level-Order Generation
 *
 * Time Complexity    : O(A)
 * Space Complexity   : O(A)
 *
 * Idea:
 * Generate numbers whose digits contain only 1, 2, and 3.
 *
 * Start with:
 *      1, 2, 3
 *
 * For every number removed from the queue, generate its next
 * three numbers:
 *
 *      cur * 10 + 1
 *      cur * 10 + 2
 *      cur * 10 + 3
 *
 * Example:
 *
 * Queue initially:
 *      1, 2, 3
 *
 * Remove 1:
 *      Add 11, 12, 13
 *
 * Remove 2:
 *      Add 21, 22, 23
 *
 * Remove 3:
 *      Add 31, 32, 33
 *
 * Therefore the generated sequence is:
 *
 *      1, 2, 3, 11, 12, 13, 21, 22, 23, ...
 *
 * The queue naturally maintains the required ordering.
 * ============================================================
 */

public class GenerateNumbers {

    public static int[] solve(int A) {

        Queue<Integer> queue = new LinkedList<>();

        // First three valid numbers
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        int[] answer = new int[A];

        // Generate exactly A numbers
        for (int i = 0; i < A; i++) {

            // Take the smallest available number
            int current = queue.poll();

            // Store it in the answer
            answer[i] = current;

            // Generate the next numbers by appending
            // 1, 2 and 3 to the current number.
            queue.offer(current * 10 + 1);
            queue.offer(current * 10 + 2);
            queue.offer(current * 10 + 3);
        }

        return answer;
    }

    public static void main(String[] args) {

        int A = 10;

        int[] result = solve(A);

        System.out.println("First " + A + " numbers:");

        System.out.println(Arrays.toString(result));
    }
}