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
 * 1. prev -> Previous node
 * 2. curr -> Current node
 * 3. next -> Next node
 *
 * For every node:
 * - Save the next node.
 * - Reverse the current node's pointer.
 * - Move prev and curr one step forward.
 *
 * Example:
 *
 * Original:
 * 1 -> 2 -> 3 -> 4 -> null
 *
 * Reversed:
 * 4 -> 3 -> 2 -> 1 -> null
 * ============================================================
 */

public class ReverseLinkedList {

    // Definition of a singly linked-list node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseList(ListNode A) {

        ListNode curr = A;
        ListNode prev = null;

        while (curr != null) {

            // Save the next node before changing curr.next
            ListNode next = curr.next;

            // Reverse the current node's pointer
            curr.next = prev;

            // Move prev one step forward
            prev = curr;

            // Move curr one step forward
            curr = next;
        }

        // prev is the new head of the reversed list
        return prev;
    }

    public static void main(String[] args) {

        // Create:
        // 1 -> 2 -> 3 -> 4 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Reverse the linked list
        head = reverseList(head);

        // Print reversed list
        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }

        System.out.println("null");
    }
}