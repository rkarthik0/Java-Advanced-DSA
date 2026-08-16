import java.util.*;

/**
 * ============================================================
 * Problem            : Implement Queue Using Stacks
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/implement-queue-using-stacks/
 * Difficulty         : Easy
 *
 * Approach           : Stack
 * Algorithm          : Two Stack Queue
 *
 * Time Complexity    : Amortized O(1) per operation
 *                       O(n) when transferring elements
 *                       between the two stacks.
 *
 * Space Complexity   : O(n)
 *
 * Idea:
 * A queue follows FIFO:
 *
 *     First In -> First Out
 *
 * A stack follows LIFO:
 *
 *     Last In -> First Out
 *
 * We use two stacks:
 *
 * s1 -> Stores newly pushed elements.
 * s2 -> Provides elements in queue order.
 *
 * When s2 is empty, move all elements from s1 to s2.
 * This reverses their order and makes the oldest element
 * available at the top of s2.
 * ============================================================
 */

public class UserQueue {

    static Stack<Integer> s1;
    static Stack<Integer> s2;

    /**
     * Initialize the queue.
     */
    public UserQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * Add an element to the back of the queue.
     */
    public static void push(int X) {
        s1.push(X);
    }

    /**
     * Move elements from s1 to s2 only when s2 is empty.
     *
     * This keeps the oldest element at the top of s2.
     */
    private static void transfer() {

        if (s2.isEmpty()) {

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }

    /**
     * Remove and return the element from the front.
     */
    public static int pop() {

        transfer();

        return s2.pop();
    }

    /**
     * Return the element at the front without removing it.
     */
    public static int peek() {

        transfer();

        return s2.peek();
    }

    /**
     * Check whether the queue is empty.
     */
    public static boolean empty() {

        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {

        UserQueue queue = new UserQueue();

        // Add elements:
        // Queue -> 10, 20, 30
        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println("Front: " + queue.peek());

        // Removes 10
        System.out.println("Removed: " + queue.pop());

        // Removes 20
        System.out.println("Removed: " + queue.pop());

        // Add another element
        queue.push(40);

        System.out.println("Front: " + queue.peek());

        // Removes 30
        System.out.println("Removed: " + queue.pop());

        // Removes 40
        System.out.println("Removed: " + queue.pop());

        System.out.println("Queue Empty: " + queue.empty());
    }
}