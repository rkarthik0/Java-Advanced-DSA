package DataStructures.Queue;

import java.util.Stack;

/**
 * ============================================================
 * Problem            : Implement Queue using Stacks
 * Platform           : LeetCode
 * Link               : https://leetcode.com/problems/implement-queue-using-stacks/
 * Difficulty         : Easy
 *
 * Approach           : Two Stacks
 * Algorithm          : Stack Simulation
 *
 * Time Complexity    :
 *      push()  -> O(1)
 *      pop()   -> Amortized O(1)
 *      peek()  -> Amortized O(1)
 *      empty() -> O(1)
 *
 * Space Complexity   : O(n)
 * ============================================================
 */

public class ImplementQueueUsingStacks {

    static class UserQueue {

        // Stack used for push operations
        private static Stack<Integer> s1;

        // Stack used for pop/peek operations
        private static Stack<Integer> s2;

        /**
         * Initializes the queue.
         */
        UserQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /**
         * Pushes an element to the back of the queue.
         *
         * @param x Element to be inserted
         */
        public static void push(int x) {
            s1.push(x);
        }

        /**
         * Removes and returns the front element.
         *
         * @return Front element
         */
        public static int pop() {

            // Transfer elements only when s2 is empty
            if (s2.isEmpty()) {

                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            return s2.pop();
        }

        /**
         * Returns the front element without removing it.
         *
         * @return Front element
         */
        public static int peek() {

            // Transfer elements only when s2 is empty
            if (s2.isEmpty()) {

                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            return s2.peek();
        }

        /**
         * Checks whether the queue is empty.
         *
         * @return true if queue is empty, otherwise false
         */
        public static boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

    public static void main(String[] args) {

        // Create queue
        UserQueue queue = new UserQueue();

        // Push elements
        queue.push(10);
        queue.push(20);
        queue.push(30);

        // Peek front element
        System.out.println("Front Element: " + queue.peek());

        // Remove front element
        System.out.println("Popped Element: " + queue.pop());

        // Peek again
        System.out.println("Front Element: " + queue.peek());

        // Check if queue is empty
        System.out.println("Is Queue Empty? " + queue.empty());
    }
}