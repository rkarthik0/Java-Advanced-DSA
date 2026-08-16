import java.util.*;

/**
 * ============================================================
 * Problem            : First Non-Repeating Character in Stream
 * Created By         : Karthik R
 * Difficulty         : Easy
 *
 * Approach           : Queue + Frequency Array
 * Algorithm          : Streaming / FIFO Processing
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(n)
 *
 * Idea:
 * For every character added to the stream, find the first
 * character that has appeared exactly once so far.
 *
 * We use:
 *
 * 1. Frequency array
 *    - fr[i] stores how many times a character has appeared.
 *
 * 2. Queue
 *    - Stores characters in the order in which they appeared.
 *    - The front is the earliest possible non-repeating
 *      character.
 *
 * For every character:
 *
 *     frequency[c]++
 *     queue.offer(c)
 *
 * Then remove characters from the front while their frequency
 * is greater than 1.
 *
 * If the queue becomes empty:
 *     append '#'
 *
 * Otherwise:
 *     append queue.peek()
 * ============================================================
 */

public class FirstNonRepeatingCharacter {

    public static String solve(String A) {

        StringBuilder answer = new StringBuilder();

        // Queue maintains characters in their insertion order.
        Queue<Character> queue = new LinkedList<>();

        // Frequency of each lowercase English character.
        int[] frequency = new int[26];

        // Process the stream character by character.
        for (int i = 0; i < A.length(); i++) {

            char current = A.charAt(i);

            // Increase frequency of current character.
            frequency[current - 'a']++;

            // Add current character to the queue.
            queue.offer(current);

            // Remove all characters that are no longer unique.
            while (!queue.isEmpty()
                    && frequency[queue.peek() - 'a'] > 1) {

                queue.poll();
            }

            // Front of queue is the first non-repeating character.
            if (queue.isEmpty()) {
                answer.append('#');
            } else {
                answer.append(queue.peek());
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {

        String A = "abadbc";

        String result = solve(A);

        System.out.println("Input: " + A);
        System.out.println("Output: " + result);
    }
}