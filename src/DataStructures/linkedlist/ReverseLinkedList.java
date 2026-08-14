/**
 * ============================================================
 * Problem            : Reverse Linked List
 * Created By         : Karthik R
 * Link               : https://leetcode.com/problems/reverse-linked-list/
 * Difficulty         : Easy
 *
 * Approach           : Linked List
 * Algorithm          : Iterative Reversal
 *
 * Time Complexity    : O(n)
 * Space Complexity   : O(1)
 *
 * Idea:
 * Maintain three pointers:
 *
 * 1. prev    -> Previous node
 * 2. curr    -> Current node
 * 3. next    -> Next node
 *
 * For every node:
 * - Save the next node.
 * - Reverse the current node's pointer.
 * - Move prev and curr one step forward.
 * ============================================================
 */

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode A) {

        ListNode curr = A;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {

            // Save the next node before changing the link
            next = curr.next;

            // Reverse the current node's pointer
            curr.next = prev;

            // Move prev to the current node
            prev = curr;

            // Move curr to the next node
            curr = next;
        }

        // prev is now the new head of the reversed list
        return prev;
    }
}