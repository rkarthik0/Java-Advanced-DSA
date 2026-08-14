/**
 * ============================================================
 * Problem            : Delete Node at Given Position
 * Created By         : Karthik R
 * Link               :
 * Difficulty         : Easy
 *
 * Approach           : Linked List
 * Algorithm          : Traversal and Pointer Manipulation
 *
 * Time Complexity    : O(B)
 * Space Complexity   : O(1)
 *
 * Idea:
 * Delete the node at index B.
 *
 * - If B == 0, the head itself must be removed.
 * - Otherwise, move to the node at index B - 1.
 * - Skip the node at index B by changing the next pointer.
 * ============================================================
 */

public class DeleteNodeAtPosition {

    // Linked List Node
    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode solve(ListNode A, int B) {

        // Delete the head node
        if (B == 0) {
            return A.next;
        }

        ListNode current = A;

        // Move to the node just before the node to delete
        for (int i = 0; i < B - 1; i++) {
            current = current.next;
        }

        // Skip the node at index B
        current.next = current.next.next;

        // Head remains unchanged
        return A;
    }

    // Helper method to print the linked list
    private static void printList(ListNode head) {

        ListNode current = head;

        while (current != null) {

            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Create:
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Delete node at index 2
        // 1 -> 2 -> 4 -> 5
        head = solve(head, 2);

        System.out.println("Linked List after deletion:");
        printList(head);
    }
}